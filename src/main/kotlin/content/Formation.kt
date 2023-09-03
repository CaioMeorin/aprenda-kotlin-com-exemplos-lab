/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 *
 */

package src.content

import src.user.Student

class Formation private constructor(builder: Builder) {


    private var name: String
    private var uniqueTechStacks: MutableSet<String> = mutableSetOf()
    private var uniqueStudents: MutableSet<Student> = mutableSetOf()
    private var uniqueContents: Set<IContent>
    private var duration: Int = 0
    private var completed: Boolean = false

    class Builder {
        private lateinit var name: String
        private lateinit var uniqueContents: Set<IContent>

        fun setName(name: String) = apply { this.name = name }
        fun setContents(uniqueContents: Set<IContent>) = apply { this.uniqueContents = uniqueContents }
        fun getName() = name
        fun getUniqueContents() = uniqueContents
        fun build() = Formation(this)
    }

    init {
        name = builder.getName()
        uniqueContents = builder.getUniqueContents()
        combineContentStacks()
        combineContentDuration()
    }

    fun enroll(student: Student) {
        if (!uniqueStudents.contains(student)) {
            uniqueStudents.add(student)
        }
    }

    private fun combineContentStacks() {
        uniqueContents.forEach {
            if (!uniqueTechStacks.containsAll(it.techStack)) {
                uniqueTechStacks.addAll(it.techStack)
            }
        }
    }

    private fun combineContentDuration() {
        uniqueContents.forEach {
            duration += it.duration
        }
    }

    /**
     * Check completed and add points if necessary.
     * If `content` is null, then, it will check the formation as complete
     * adding all of its contents as completedContents to the respective student
     */
    fun completeContent(student: Student, content: IContent? = null) {
        if (content == null && !completed) {
            uniqueContents.forEach {
                when (it.challengeValue) {
                    Int.MIN_VALUE -> {}
                    else -> student.addPoints(it.challengeValue)
                }
                student.addAcquiredCertification(it.certification)
                student.addCompletedContent(it.name)
                it.completed = true
            }
            student.addCompletedFormation(name)
            student.addStackSkill(uniqueTechStacks)
            completed = true
        } else if (content != null && !content.completed) {
            when (content.challengeValue) {
                Int.MIN_VALUE -> {}
                else -> student.addPoints(content.challengeValue)
            }
            student.addAcquiredCertification(content.certification)
            student.addCompletedContent(content.name)
            student.addStackSkill(content.techStack)
            content.completed = true
        }
    }

    fun getUniqueStudents() = uniqueStudents
    fun getName() = name
    fun getUniqueContents() = uniqueContents
    fun getDuration() = duration
    fun getCompleted() = completed
    fun getUniqueTechStacks() = uniqueTechStacks

}