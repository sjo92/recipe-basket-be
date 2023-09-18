@Entity
@Table(name = "Rating")
data class Rating(
    @EmbeddedId
    val id: RatingId,

    @Column(nullable = false)
    val comment: String,

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
data class RatingId(
    val recipeMetaDataId: String,
    val userId: String
)