/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 *
 */

package src.user

data class Student(val name: String, val dateOfBirth: String, var email: String) {
    private var reputation: Int = 0
    private var phoneNumber: String = ""
    private var address: String = ""
    private var totalPoints: Int = 0
    private var completedContents: MutableSet<String> = mutableSetOf()
    private var completedFormations: MutableSet<String> = mutableSetOf()
    private var acquiredCertifications: MutableSet<String> = mutableSetOf()
    private var stackSkills: MutableSet<String> = mutableSetOf()

    fun addCompletedFormation(name: String) {
        if (!completedFormations.contains(name)) {
            completedFormations.add(name)
        }
    }

    fun addCompletedContent(name: String) {
        if (!completedContents.contains(name)) {
            completedContents.add(name)
        }
    }

    fun addAcquiredCertification(name: String) {
        if (!acquiredCertifications.contains(name)) {
            acquiredCertifications.add(name)
        }
    }

    fun addStackSkill(techStack: MutableSet<String>) {
        techStack.forEach {
            if (!stackSkills.contains(it)) {
                stackSkills.add(it)
            }
        }
    }

    fun addPoints(points: Int) {
        totalPoints += points
    }

    fun calculateReputation() {
        reputation =
            ((totalPoints + completedFormations.size + completedContents.size + stackSkills.size) * 0.20).toInt()
    }

    fun setAddress(value: String) {
        address = value
    }

    fun setPhoneNumber(value: String) {
        phoneNumber = value
    }

    fun getPhoneNumber() = phoneNumber
    fun getAddress() = address
    fun getTotalPoints() = totalPoints
    fun getCompletedContents() = completedContents
    fun getCompletedFormations() = completedFormations
    fun getAcquiredCertifications() = acquiredCertifications
    fun getStackSkills() = stackSkills
    fun getReputation() = reputation

}