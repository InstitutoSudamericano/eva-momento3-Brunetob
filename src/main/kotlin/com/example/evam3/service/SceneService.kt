package com.example.evam3.service

import com.example.evam3.entity.Scene
import com.example.evam3.repository.SceneRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class SceneService {
    @Autowired
    lateinit var sceneRepository: SceneRepository

    fun listByFilmId(filmId: Long): List<Scene> {
        return sceneRepository.findByFilmId(filmId)
    }

    fun save(scene: Scene): Scene {
        try {
            scene.description?.takeIf { it.trim().isNotEmpty() }
                ?: throw Exception("La descripción de la escena no debe ser vacía")

            scene.budget?.takeIf { it >= 0 }
                ?: throw Exception("El presupuesto de la escena debe ser mayor o igual a cero")

            scene.minutes?.takeIf { it > 0 }
                ?: throw Exception("La duración de la escena debe ser mayor a cero")

            return sceneRepository.save(scene)
        } catch (ex: Exception) {
            throw ResponseStatusException(HttpStatus.BAD_REQUEST, ex.message)
        }
    }
}
