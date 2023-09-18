package com.rb.recipebasket.model

@Entity
@Table(name = "RecipeMetaData")
data class RecipeMetaData(
    @Id
    val id: String,

    @Column(nullable = false)
    val title: String,

    @Column(nullable = false, columnDefinition = "BYTEA")
    val titlePhoto: ByteArray,

    @Column(nullable = false, precision = 65, scale = 30)
    val totalRating: BigDecimal,

    @Column(nullable = false)
    val difficulty: String,

    @Column(nullable = false)
    val duration: String,

    @Column(nullable = false)
    val calories: Int,

    @Column(nullable = false)
    val createdAt: LocalDateTime = LocalDateTime.now(),

    @Column(nullable = false)
    val updatedAt: LocalDateTime = LocalDateTime.now()
)
