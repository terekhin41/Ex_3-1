package content

data class File(
    val id : Int,
    val ownerId : Int,
    val title : String,
    val size : Int
)