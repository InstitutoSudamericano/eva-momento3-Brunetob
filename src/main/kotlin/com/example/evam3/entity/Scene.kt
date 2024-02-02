package com.example.evam3.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import java.math.BigDecimal

@Entity
@Table(name = "scene")
class Scene {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null

    @Column(name = "description")
    var description: String? = null

    @Column(name = "budget")
    var budget: BigDecimal? = null

    @Column(name = "minutes")
    var minutes: Int? = null

    @ManyToOne
    @JoinColumn(name = "film_id")
    var film: Film? = null
}