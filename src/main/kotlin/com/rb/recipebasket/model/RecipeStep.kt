@Entity
@Table(name = "RecipeStep")
data class RecipeStep(
    @Id
    val id: String,

    @Column(nullable = false)
    val stepNumber: Int,

    @Column(nullable = false)
    val instructionText: String,

    @Column(nullable = false)
    val instructionPhoto: String,

    @Column(nullable = false)
    val createdAt: LocalDateTime = LocalDateTime.now(),

    @Column(nullable = false)
    val updatedAt: LocalDateTime = LocalDateTime.now(),

    @ManyToOne
    @JoinColumn(name = "recipeMetaDataId", nullable = false)
    val recipeMetaData: RecipeMetaData
)
