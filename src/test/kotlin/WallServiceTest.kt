import org.junit.Test

import org.junit.Assert.*
import post.Post

class WallServiceTest {
    private val ws = WallService()

    @Test
    fun add() {
        val result = ws.add(Post(1)).id

        assertEquals(1, result)
    }

    @Test
    fun update_containedPost() {
        val post = Post(1)
        val addedPost = ws.add(post)

        val result = ws.update(addedPost)

        assertTrue(result)
    }

    @Test
    fun update_notContainedPost() {
        val post = Post(1)

        val result = ws.update(post)

        assertFalse(result)
    }
}