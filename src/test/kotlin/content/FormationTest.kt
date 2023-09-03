package content

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import src.content.ContentFactory
import src.content.Formation
import src.content.IContent
import src.user.Student
import src.utils.Difficulty

class FormationTest {

    private val content: IContent =
        ContentFactory(
            "Kotlin",
            Difficulty.BEGINNER,
            60,
            techStack = mutableSetOf("Android", "Kotlin")
        )
    private val content2: IContent =
        ContentFactory(
            "Kotlin Project",
            Difficulty.BEGINNER,
            60,
            challengeValue = 200,
            techStack = mutableSetOf("Android","Kotlin","OOP")
        )
    private val formation: Formation = Formation.Builder()
        .setName("Android with Kotlin")
        .setContents(mutableSetOf(content, content2))
        .build()
    private val student: Student = Student("Caio", "24/04/1993", "caio@gmail.com")
    private val student2: Student = Student("Pedro", "04/01/2001", "pedro@gmail.com")

    @Test
    fun `Enroll students in formation`() {
        formation.enroll(student)
        formation.enroll(student2)
        println(formation.getUniqueStudents())
        assertEquals(true, formation.getUniqueStudents().containsAll(mutableSetOf(student, student2)))
    }

    @Test
    fun `Completing formation`() {
        formation.completeContent(student)
        println("Formation marked as completed: ${formation.getCompleted()}")
        assertEquals(true, formation.getCompleted())
        formation.getUniqueContents().forEach {
            println("Individual ${it.name} marked as complete: ${it.completed}")
        }

    }
    @Test
    fun `Completing individual content`() {
        formation.completeContent(student, content)
        assertEquals(true, content.completed)
        formation.getUniqueContents().forEach {
            println("Individual ${it.name} marked as complete: ${it.completed}")
        }
    }

    @Test
    fun `If have all students that were enrolled, it should be true`() {
        formation.enroll(student)
        formation.enroll(student2)
        assertEquals(true, formation.getUniqueStudents().containsAll(mutableSetOf(student, student2)))
    }

    @Test
    fun `True if name is equal to Android with Kotlin`(){
        assertEquals("Android with Kotlin", formation.getName())
    }

    @Test
    fun `Should pass if getUniqueContents is equal to mutableSetOf(content, content2)`() {
        assertEquals(mutableSetOf(content, content2), formation.getUniqueContents())
    }

    @Test
    fun `Formation duration should be exactly equal the sum of every content's duration`(){
        println("Duration: ${formation.getDuration()}")
        assertEquals(120, formation.getDuration())
    }

    @Test
    fun `Shall pass if getCompleted is equal to true after completing the formation`(){
        assertEquals(false, formation.getCompleted())
        formation.completeContent(student)
        assertEquals(true, formation.getCompleted())
    }

    @Test
    fun `uniqueTechStacks should be exactly equal the union of all content's stacks` () {
        println("value for UniqueTechStacks: ${formation.getUniqueTechStacks()}")
        assertEquals(mutableSetOf("Android", "Kotlin", "OOP"), formation.getUniqueTechStacks())
    }

}