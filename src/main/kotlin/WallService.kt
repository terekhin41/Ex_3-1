import post.*
import java.time.Instant

private var wallId : Int = 0

class WallService {
    init {
        wallId += 1
    }
    private var storage = emptyArray<Post>()
    private var postId : Int = 0
    private var id = wallId

    fun add(post: Post): Post {
        postId += 1
        val publishingPost = post.copy(
            id = postId,
            date = Instant.now().epochSecond.toInt(),
            ownerId = id
        )
        storage += publishingPost
        return storage.last()
    }

    fun update(post: Post): Boolean {
        if (post.ownerId != wallId || post.id > storage.size) return false

        for ((index, oldPost) in storage.withIndex()) {
            if (post.id == index) {
                storage[index] = post.copy(
                    ownerId = oldPost.ownerId,
                    id = oldPost.id,
                    date = oldPost.date
                )
            }
        }
        return true
    }

    fun like(post: Post) {
        val likes = Likes(count = post.likes.count + 1)
        update(post.copy(likes = likes))
    }

    fun attach(attachment : Attachment, post: Post) {
        when (attachment) {
            is AudioAttachment -> TODO()
            is FileAttachment -> TODO()
            is GraffitiAttachment -> TODO()
            is PhotoAttachment -> TODO()
            is VideoAttachment -> TODO()
        }
    }
}