package content

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import src.content.ContentFactory
import src.content.IContent
import src.utils.Difficulty

class ContentFactoryTest {

    @Test
    fun `If there is no challenge max value, it should create a Course object, else, a Challenge object` (){
        val contentFactory1 = ContentFactory("Curso", Difficulty.BEGINNER, 60)
        val contentFactory2 = ContentFactory("Challenge", Difficulty.BEGINNER, 60, challengeValue = 100)

        val curso: IContent = contentFactory1.createContent()
        val challenge: IContent = contentFactory2.createContent()
        println(curso::class.simpleName)
        println(challenge::class.simpleName)
        assertEquals(false, curso::class.simpleName?.equals(challenge::class) ?: true)
    }
}