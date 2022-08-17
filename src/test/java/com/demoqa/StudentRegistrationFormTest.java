package com.demoqa;

import com.codeborne.selenide.Configuration;
import com.demoqa.pages.RegistrationFormPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class StudentRegistrationFormTest {

    RegistrationFormPage registrationFormPage = new RegistrationFormPage();

    @BeforeAll
    static void configure() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void fillFormTest() {
        registrationFormPage
                .openPage()
                .setFirstName("Sergey")
                .setLastName("Sviridov")
                .setEmail("super@test.com")
                .setGender("Male")
                .setUserNumber("9171234567")
                .setBirthDate("08", "October", "1993")
                .setSubjects("Computer Science")
                .setHobbies("Sports")
                .uploadPicture("face.png")
                .setCurrentAddress("960 AVENUE OF THE AMERICAS NEW YORK")
                .setState("Haryana")
                .setCity("Panipat")
                .pressSubmitButton();

        registrationFormPage
                .checkResultsModalIsVisible()
                .checkResult("Student Name", "Sergey Sviridov")
                .checkResult("Student Email", "super@test.com")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "9171234567")
                .checkResult("Date of Birth", "08 October,1993")
                .checkResult("Subjects", "Computer Science")
                .checkResult("Hobbies", "Sports")
                .checkResult("Picture", "face.png")
                .checkResult("Address", "960 AVENUE OF THE AMERICAS NEW YORK")
                .checkResult("State and City", "Haryana Panipat");
    }
}
