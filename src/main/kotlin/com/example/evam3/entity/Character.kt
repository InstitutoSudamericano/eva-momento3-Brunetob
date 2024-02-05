package com.example.evam3.entity

import jakarta.persistence.*

@Entity
@Table(name = "character")
class Character {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    val id: Long? = null
    var description: String? = null
    var cost: Double? = null
    var hability: String? = null

    @ManyToOne
    @JoinColumn(name = "scene_id", nullable = false)
    var scene: Scene? = null
}
