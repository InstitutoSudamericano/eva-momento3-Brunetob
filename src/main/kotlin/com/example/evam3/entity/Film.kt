package com.example.evam3.entity

import jakarta.persistence.*

@Entity
@Table (name="film")
class Film {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    val id: Long? = null
    @Column(updatable = false)
    var title: String? = null
    var director: String? = null
    var duration: Long? = null
}