package com.example.evam3.entity

import jakarta.persistence.*

@Entity
@Table(name = "scene")
class Scene {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    val id: Long? = null
    var description: String? = null
    var budget: Double? = null
    var minutes: Int? = null

    @ManyToOne
    @JoinColumn(name = "film_id", nullable = false)
    var film: Film? = null
}