package com.rb.recipebasket.model

import jakarta.persistence.*
import org.jetbrains.annotations.NotNull
import org.springframework.data.relational.core.mapping.Column
import java.time.LocalDateTime

@Entity
@Table(name = "Favorite")
class Favorite(
    @EmbeddedId
    val id: FavoriteId,

    @NotNull
    @Column
    val notes: String,

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
    constructor() : this(FavoriteId(), "", LocalDateTime.now(), LocalDateTime.now(), User(), RecipeMetaData())
}

@Embeddable
data class FavoriteId(
    val recipeMetaDataId: String,
    val userId: String
) {
    constructor() : this("", "")
}
