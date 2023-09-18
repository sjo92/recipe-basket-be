package com.rb.recipebasket.model

import jakarta.persistence.*
import org.jetbrains.annotations.NotNull
import org.springframework.data.relational.core.mapping.Column
import java.time.LocalDateTime

@Entity
@Table(name = "RecipeStep")
data class RecipeStep(
    @Id
    val id: String,

    @NotNull
    @Column
    val stepNumber: Int,

    @NotNull
    @Column
    val instructionText: String,

    @NotNull
    @Column
    val instructionPhoto: String,

    @NotNull
    @Column
    val createdAt: LocalDateTime = LocalDateTime.now(),

    @NotNull
    @Column
    val updatedAt: LocalDateTime = LocalDateTime.now(),

    @ManyToOne
    @JoinColumn(name = "recipeMetaDataId", nullable = false)
    val recipeMetaData: RecipeMetaData
) {
    constructor() : this("", 0, "", "", LocalDateTime.now(), LocalDateTime.now(), RecipeMetaData())
}
