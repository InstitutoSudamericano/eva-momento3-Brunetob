package com.example.evam3.repository

import com.example.evam3.entity.Film
import com.example.evam3.entity.Scene
import org.springframework.data.jpa.repository.JpaRepository

interface SceneRepository : JpaRepository<Scene, Int> {
    fun findByFilm(film: Film): List<Scene>
}

/*interface SceneRepository {
}*/
