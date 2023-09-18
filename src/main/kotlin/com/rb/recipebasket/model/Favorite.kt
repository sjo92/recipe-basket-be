@Entity
@Table(name = "Favorite")
data class Favorite(
    @EmbeddedId
    val id: FavoriteId,

    @Column(nullable = false)
    val notes: String,

    @Column(nullable = false)
    val createdAt: LocalDateTime = LocalDateTime.now(),

    @Column(nullable = false)
    val updatedAt: LocalDateTime = LocalDateTime.now(),

    @ManyToOne
    @MapsId("userId")
    val user: User,

    @ManyToOne
    @MapsId("recipeMetaDataId")
    val recipeMetaData: RecipeMetaData
)

@Embeddable
data class FavoriteId(
    val recipeMetaDataId: String,
    val userId: String
)