package com.example.evam3.controller

import com.example.evam3.entity.Film
import com.example.evam3.entity.Scene
import com.example.evam3.service.SceneService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/scenes")
class SceneController {

    @Autowired
    lateinit var sceneService: SceneService

    @GetMapping("/{id}")
    fun findAllByFilm(@PathVariable id: Int): List<Scene> {
        var film = Film(id = id)
        return sceneService.findAllByFilm(film)
    }

    @PostMapping
    fun save(@RequestBody scene: Scene): Scene {
        return sceneService.save(scene)
    }
}