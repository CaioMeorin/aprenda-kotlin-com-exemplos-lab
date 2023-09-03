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

sealed interface IContent {
    val name: String
    val difficulty: Difficulty
    val duration: Int
    var completed: Boolean
    val techStack: MutableSet<String>
    val challengeValue: Int
    val certification: String
}