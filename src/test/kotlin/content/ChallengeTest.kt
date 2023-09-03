package content

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import src.content.Challenge
import src.utils.Difficulty

class ChallengeTest {

    private val challenge: Challenge = Challenge(
        "Kotlin Project",
        certification = "Kotlin Project",
        difficulty = Difficulty.ADVANCED,
        duration = 60,
        techStack = mutableSetOf("Android", "Kotlin"),
        challengeValue = 100
    )

    @Test
    fun getName() {
        assertEquals("Kotlin Project", challenge.name)
    }

    @Test
    fun getDifficulty() {
        assertEquals(Difficulty.ADVANCED, challenge.difficulty)
    }

    @Test
    fun getDuration() {
        assertEquals(60, challenge.duration)
    }

    @Test
    fun getTechStack() {
        assertEquals(mutableSetOf("Kotlin", "Android"), challenge.techStack)
    }

    @Test
    fun getChallengeValue() {
        assertEquals(100, challenge.challengeValue)
    }

    @Test
    fun getCertification() {
        assertEquals("Kotlin Project", challenge.certification)
    }
}