package com.rb.recipebasket.model

import jakarta.persistence.*
import org.jetbrains.annotations.NotNull
import org.springframework.data.relational.core.mapping.Column
import java.time.LocalDateTime

@Entity
@Table(name = "GroceryList")
data class GroceryList(
    @Id
    val id: String,
    @NotNull
    @Column
    val name: String,
    @NotNull
    @Column
    val status: String,
    @NotNull
    @Column
    val createdAt: LocalDateTime = LocalDateTime.now(),
    @NotNull
    @Column
    val updatedAt: LocalDateTime = LocalDateTime.now(),

    @ManyToOne
    @MapsId("userId")
    val user: User
) {
    constructor() : this("", "", "", LocalDateTime.now(), LocalDateTime.now(), User())
}
