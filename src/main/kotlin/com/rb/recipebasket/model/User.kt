package com.rb.recipebasket.model

import javax.persistence.*

@Entity
@Table(name = "User")
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: String,
    
    @Column(nullable = false)
    val email: String,

    @Column(nullable = false)
    val createdAt: LocalDateTime = LocalDateTime.now(),

    @Column(nullable = false)
    val updatedAt: LocalDateTime = LocalDateTime.now()

    // OneToMany relationship for favorite dishes (Favorite Entity)
    @OneToMany(mappedBy = "user", cascade = [CascadeType.ALL], orphanRemoval = true)
    val favorites: MutableList<Favorite> = mutableListOf(),

    // OneToMany relationship for ratings given by user (Rating Entity)
    @OneToMany(mappedBy = "user", cascade = [CascadeType.ALL], orphanRemoval = true)
    val ratings: MutableList<Rating> = mutableListOf(),

    // OneToMany relationship for grocery lists (GroceryList Entity)
    @OneToMany(mappedBy = "user", cascade = [CascadeType.ALL], orphanRemoval = true)
    val groceryLists: MutableList<GroceryList> = mutableListOf()
)
