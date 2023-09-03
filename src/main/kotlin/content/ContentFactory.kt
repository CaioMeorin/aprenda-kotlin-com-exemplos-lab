/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 *
 */

package src.content

import src.utils.Difficulty
import kotlin.math.abs

object ContentFactory {
    private const val NO_CHALLENGE: Int = Int.MIN_VALUE

    fun createContent(
        name: String,
        difficulty: Difficulty,
        duration: Int,
        techStack: MutableSet<String>,
        challengeValue: Int = NO_CHALLENGE
    ): IContent {
        val certification: String = name
        return when (challengeValue) {
            NO_CHALLENGE -> Course(name, difficulty, duration, techStack, certification)
            else -> Challenge(name, difficulty, duration, techStack, certification, abs(challengeValue))
        }
    }
}