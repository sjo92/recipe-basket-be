package com.rb.recipebasket.model

import jakarta.persistence.*
import org.springframework.data.relational.core.mapping.Column

@Entity
@Table(name = "Category")
data class Category(
    @Id
    val id: String,

    @Column
    val name: String,

    @ManyToOne
    @JoinColumn(name = "parentCategoryId")
    val parentCategory: Category? = null
) {
    constructor() : this("", "", null)
}
