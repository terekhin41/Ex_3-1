import post.*
import java.time.Instant

private var wallId : Int = 0

class WallService {
    init {
        wallId += 1
    }
    private var posts = emptyArray<Post>()
    private var comments = emptyArray<Array<Comment>>()
    private var postId : Int = 0
    private var id = wallId

    fun add(post: Post): Post {
        postId += 1
        val publishingPost = post.copy(
            id = postId,
            date = Instant.now().epochSecond.toInt(),
            ownerId = id
        )
        posts += publishingPost
        comments += emptyArray<Comment>()
        return posts.last()
    }

    fun update(post: Post): Boolean {
        if (contains(post)) {
            for ((index, oldPost) in posts.withIndex()) {
                if (post.id - 1 == index) {
                    posts[index] = post.copy(
                        ownerId = oldPost.ownerId,
                        id = oldPost.id,
                        date = oldPost.date
                    )
                    return true
                }
            }
        }
        return false
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

    fun createComment(postId : Int, comment: Comment) : Comment {
        if (contains(postId)) {
            comments[postId - 1] = comments[postId - 1].plus(comment)
            return comments[postId - 1].last()
        } else throw PostNotFoundException()
    }

    fun getComments(post: Post) : Array<Comment> {
        if (contains(post)) {
            return comments[post.id - 1]
        } else throw PostNotFoundException()
    }

    private fun contains(post : Post) : Boolean {
        return post.ownerId == wallId && post.id <= posts.size
    }

    private fun contains(postId : Int) : Boolean {
        return postId <= posts.size
    }
}

class PostNotFoundException : Exception()