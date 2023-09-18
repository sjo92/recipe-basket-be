@Entity
@Table(name = "Category")
data class Category(
    @Id
    val id: String,

    @Column(nullable = false)
    val name: String,

    @ManyToOne
    @JoinColumn(name = "parentCategoryId")
    val parentCategory: Category? = null
)
