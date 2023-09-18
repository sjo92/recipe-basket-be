package com.rb.recipebasket.model

import jakarta.persistence.*
import org.jetbrains.annotations.NotNull
import org.springframework.data.relational.core.mapping.Column
import java.time.LocalDateTime

@Entity
@Table(name = "User")
open class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: String,

    @NotNull
    @Column
    val email: String,

    @NotNull
    @Column
    val createdAt: LocalDateTime = LocalDateTime.now(),

    @NotNull
    @Column
    val updatedAt: LocalDateTime = LocalDateTime.now(),

    // OneToMany relationship for favorite dishes (Favorite Entity)
    @OneToMany(mappedBy = "user", cascade = [CascadeType.ALL], orphanRemoval = true)
    val favorites: MutableList<Favorite> = mutableListOf(),

    // OneToMany relationship for ratings given by user (Rating Entity)
    @OneToMany(mappedBy = "user", cascade = [CascadeType.ALL], orphanRemoval = true)
    val ratings: MutableList<Rating> = mutableListOf(),

    // OneToMany relationship for grocery lists (GroceryList Entity)
    @OneToMany(mappedBy = "user", cascade = [CascadeType.ALL], orphanRemoval = true)
    val groceryLists: MutableList<GroceryList> = mutableListOf()
) {
    constructor() : this(
        "", "", LocalDateTime.now(), LocalDateTime.now(), mutableListOf(Favorite()), mutableListOf(
            Rating()
        ), mutableListOf(GroceryList())
    )
}
