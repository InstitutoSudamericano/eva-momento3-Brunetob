package com.example.evam3.service

import com.example.evam3.entity.Character
import com.example.evam3.repository.CharacterRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class CharacterService {
    @Autowired
    lateinit var characterRepository: CharacterRepository

    fun listBySceneId(sceneId: Long): List<Character> {
        return characterRepository.findBySceneId(sceneId)
    }

    fun save(character: Character): Character {
        try {
            character.description?.takeIf { it.trim().isNotEmpty() }
                ?: throw Exception("La descripción del personaje no debe ser vacía")

            character.cost?.takeIf { it >= 0 }
                ?: throw Exception("El costo del personaje debe ser mayor o igual a cero")

            // Puedes añadir más validaciones según tus necesidades

            return characterRepository.save(character)
        } catch (ex: Exception) {
            throw ResponseStatusException(HttpStatus.BAD_REQUEST, ex.message)
        }
    }
}
