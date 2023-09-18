package com.rb.recipebasket.model

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import org.jetbrains.annotations.NotNull
import org.springframework.data.relational.core.mapping.Column
import java.math.BigDecimal
import java.time.LocalDateTime

@Entity
@Table(name = "RecipeMetaData")
data class RecipeMetaData(
    @Id
    val id: String,

    @NotNull
    @Column
    val title: String,

    @NotNull
    @Column
    val titlePhoto: ByteArray,

    @NotNull
    @Column
    val totalRating: BigDecimal,

    @NotNull
    @Column
    val difficulty: String,

    @NotNull
    @Column
    val duration: String,

    @NotNull
    @Column
    val calories: Int,

    @NotNull
    @Column
    val createdAt: LocalDateTime = LocalDateTime.now(),

    @NotNull
    @Column
    val updatedAt: LocalDateTime = LocalDateTime.now()
) {
    constructor() : this("", "", ByteArray(0), BigDecimal(0), "", "", 0, LocalDateTime.now(), LocalDateTime.now())
}
