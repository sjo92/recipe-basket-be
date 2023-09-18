package com.rb.recipebasket.model

import jakarta.persistence.*
import org.jetbrains.annotations.NotNull
import org.springframework.data.relational.core.mapping.Column
import java.time.LocalDateTime

@Entity
@Table(name = "GroceryListItem")
data class GroceryListItem(
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
    @JoinColumn(name = "groceryListId", nullable = false)
    val groceryList: GroceryList
) {
    constructor() : this("", "", "", LocalDateTime.now(), LocalDateTime.now(), GroceryList())
}
