/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 *
 */

package src

import src.content.ContentFactory
import src.content.Formation
import src.content.IContent
import src.user.Student
import src.utils.Difficulty

// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

fun main() {
    val caio = Student("Caio", "24/04/1993", "caiomeorin.dev@gmail.com")
    val pedro = Student("Pedro", "10/10/1980", "pedro@gmail.com")

    /*
    If the content have challengeValue different from Int.MIN_VALUE it will be instantiated as Challenge,
    else as a Course object. The value passed is treated as abs(challengeValue)
    */
    val course: IContent = ContentFactory.createContent(
        name = "Kotlin Course",
        difficulty = Difficulty.INTERMEDIATE,
        duration = 60,
        techStack = mutableSetOf("Kotlin", "Mobile")
    )
    val project: IContent = ContentFactory.createContent(
        name = "Kotlin Project",
        difficulty = Difficulty.ADVANCED,
        duration = 100,
        techStack = mutableSetOf("Kotlin", "OOP"),
        challengeValue = 150
    )

    // Formation will combine all the content's stacks and duration internally.
    val formation: Formation =
        Formation.Builder().setName("Kotlin + Mobile").setContents(mutableSetOf(course, project)).build()

    caio.setAddress("Campinas")
    caio.setPhoneNumber("10 99913-9938")

    pedro.setAddress("Rio de Janeiro")

    /*
    Calculates reputation based on completed Content, Formations and stackSkills. Since totalPoints == 0,
    reputation will remain 0
    */
    caio.calculateReputation()
    pedro.calculateReputation()

    println(
        """
            --------- BEFORE FORMATION COMPLETE ----------
            STUDENT: ${caio.name}
            Address: ${caio.getAddress()}
            Phone Number: ${caio.getPhoneNumber()}
            Acquired Certifications: ${caio.getAcquiredCertifications()}
            Completed Contents: ${caio.getCompletedContents()}
            Completed Formations: ${caio.getCompletedFormations()}
            Stack Skills: ${caio.getStackSkills()}
            Total Points: ${caio.getTotalPoints()}
            Reputation: ${caio.getReputation()}
            
    """.trimIndent()
    )

    println(
        """
            --------- BEFORE FORMATION COMPLETE ----------
            STUDENT: ${pedro.name}
            Address: ${pedro.getAddress()}
            Phone Number: ${pedro.getPhoneNumber()}
            Acquired Certifications: ${pedro.getAcquiredCertifications()}
            Completed Contents: ${pedro.getCompletedContents()}
            Completed Formations: ${pedro.getCompletedFormations()}
            Stack Skills: ${pedro.getStackSkills()}
            Total Points: ${pedro.getTotalPoints()}
            Reputation: ${pedro.getReputation()}
            
    """.trimIndent()
    )

    formation.enroll(caio)
    formation.enroll(pedro)

    // completeContent without specifying the content completes the entire formation
    formation.completeContent(caio)
    formation.completeContent(pedro, project)

    // After completing a content, it shall call calculateReputation, to refresh the reputation value
    caio.calculateReputation()
    pedro.calculateReputation()

    println(
        """
            ------------------ CONTENTS -------------------
            Course certification: ${course.certification}
            Course stack: ${course.techStack}
            Course challenge value: ${course.challengeValue}
            -----------------------------------------------
            Project certification: ${project.certification}
            Project stack: ${project.techStack}
            Project challenge value: ${project.challengeValue}
            -----------------------------------------------
            Formation certification: ${formation.getCertification()}
            Formation stacks: ${formation.getUniqueTechStacks()}
            Formation students: ${formation.getUniqueStudents()}
            Formation duration: ${formation.getDuration()}
            Formation contents: ${formation.getUniqueContents()}
            
    """.trimIndent()
    )

    println(
        """
            --------- AFTER FORMATION COMPLETE ----------
            STUDENT: ${caio.name}
            Address: ${caio.getAddress()}
            Phone Number: ${caio.getPhoneNumber()}
            Acquired Certifications: ${caio.getAcquiredCertifications()}
            Completed Contents: ${caio.getCompletedContents()}
            Completed Formations: ${caio.getCompletedFormations()}
            Stack Skills: ${caio.getStackSkills()}
            Total Points: ${caio.getTotalPoints()}
            Reputation: ${caio.getReputation()}
            
    """.trimIndent()
    )

    println(
        """
            --------- AFTER FORMATION COMPLETE ----------
            STUDENT: ${pedro.name}
            Address: ${pedro.getAddress()}
            Phone Number: ${pedro.getPhoneNumber()}
            Acquired Certifications: ${pedro.getAcquiredCertifications()}
            Completed Contents: ${pedro.getCompletedContents()}
            Completed Formations: ${pedro.getCompletedFormations()}
            Stack Skills: ${pedro.getStackSkills()}
            Total Points: ${pedro.getTotalPoints()}
            Reputation: ${pedro.getReputation()}
            
    """.trimIndent()
    )
}