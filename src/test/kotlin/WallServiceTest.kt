import org.junit.Test

import org.junit.Assert.*
import post.Comment
import post.Post

class WallServiceTest {

    @Test
    fun add() {
        val ws = WallService()
        val result = ws.add(Post(1)).id

        assertEquals(1, result)
    }

    @Test
    fun update_containedPost() {
        val ws = WallService()
        val post = Post(1)
        val addedPost = ws.add(post)

        val result = ws.update(addedPost)

        assertTrue(result)
    }

    @Test
    fun update_notContainedPost() {
        val ws = WallService()
        val post = Post(1)

        val result = ws.update(post)

        assertFalse(result)
    }

    @Test
    fun createComment_containedPost() {
        val ws = WallService()
        val post = Post(1)
        val addedPost = ws.add(post)
        val createdComment = ws.createComment(addedPost.id, Comment(text = ""))

        val result = ws.getComments(addedPost).last() == createdComment

        assertTrue(result)
    }

    @Test(expected = PostNotFoundException::class)
    fun createComment_notContainedPost() {
        val ws = WallService()

        ws.createComment(1, Comment())
    }
}