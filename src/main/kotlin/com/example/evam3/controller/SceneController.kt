package com.example.evam3.controller

import com.example.evam3.entity.Scene
import com.example.evam3.service.SceneService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/scene")
class SceneController {
    @Autowired
    lateinit var sceneService: SceneService

    @GetMapping("/film/{filmId}")
    fun listByFilmId(@PathVariable filmId: Long): ResponseEntity<*> {
        return ResponseEntity(sceneService.listByFilmId(filmId), HttpStatus.OK)
    }

    @PostMapping
    fun save(@RequestBody scene: Scene): ResponseEntity<*> {
        return ResponseEntity<Scene>(sceneService.save(scene), HttpStatus.CREATED)
    }
}
