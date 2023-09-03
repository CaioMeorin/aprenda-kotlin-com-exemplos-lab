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

data class ContentFactory(
    override val name: String,
    override val difficulty: Difficulty,
    override val duration: Int,
    override var completed: Boolean = false,
    override val techStack: MutableSet<String> = mutableSetOf(),
    override var challengeValue: Int = Int.MIN_VALUE
) : IContent {

    override val certification: String = name
    fun createContent(): IContent {
        return when (challengeValue) {
            Int.MIN_VALUE -> Course(name, difficulty, duration, completed, techStack, certification)
            else -> Challenge(name, difficulty, duration, completed, techStack, abs(challengeValue), certification)
        }
    }

}