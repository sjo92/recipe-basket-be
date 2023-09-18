package com.rb.recipebasket.model

@Entity
@Table(name = "GroceryList")
data class GroceryList(
    @Id
    val id: String,

    @Column(nullable = false)
    val name: String,

    @Column(nullable = false)
    val status: String,

    @Column(nullable = false)
    val createdAt: LocalDateTime = LocalDateTime.now(),

    @Column(nullable = false)
    val updatedAt: LocalDateTime = LocalDateTime.now()

    @ManyToOne
    @JoinColumn(name = "groceryListId", nullable = false)
    val groceryList: GroceryList
)
