package com.rb.recipebasket.model

import jakarta.persistence.*
import org.jetbrains.annotations.NotNull
import org.springframework.data.relational.core.mapping.Column
import java.time.LocalDateTime

@Entity
@Table(name = "Rating")
data class Rating(
    @EmbeddedId
    val id: RatingId,

    @NotNull
    @Column
    val comment: String,

    @NotNull
    @Column
    val createdAt: LocalDateTime = LocalDateTime.now(),

    @NotNull
    @Column
    val updatedAt: LocalDateTime = LocalDateTime.now(),

    @ManyToOne
    @MapsId("userId")
    val user: User,

    @ManyToOne
    @MapsId("recipeMetaDataId")
    val recipeMetaData: RecipeMetaData
) {
    constructor() : this(RatingId(), "", LocalDateTime.now(), LocalDateTime.now(), User(), RecipeMetaData())
}

@Embeddable
data class RatingId(
    val recipeMetaDataId: String,
    val userId: String
) {
    constructor() : this("", "")
}
