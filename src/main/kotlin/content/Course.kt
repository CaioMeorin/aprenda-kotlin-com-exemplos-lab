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

data class Course(
    override val name: String,
    override val difficulty: Difficulty,
    override val duration: Int,
    override var completed: Boolean = false,
    override val techStack: MutableSet<String>,
    override val certification: String
) : IContent {
    override val challengeValue: Int = Int.MIN_VALUE
}