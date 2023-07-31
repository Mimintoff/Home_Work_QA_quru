package HomeWorks;

import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeForm {




    @BeforeAll
    static void setupClass() {
        System.setProperty("webdriver.chrome.driver", "C:\\CODE");
        WebDriverManager.chromedriver().cachePath("C:\\CODE").avoidOutputTree().setup();
        Configuration.browser = "chrome";
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }




    @Test
    void fillStudentPracticeForm(){
        String firstName = "Mikhail";
        String lastName = "Kocherginski";
        String email = "Michelle908@mail.ru";
        String mobileNumber = "9969308634";
        String gender = "Male";
        String birthDateDay = "20";
        String month  = "October";
        String year = "1995";
        String subjects = "Maths";
        String hobbies = "Music";
        String currentAddress = "Kostroma";
        String nameFile = "photo_2023-07-24_09-14-48.jpg";
        String state =  "Haryana";
        String city = "Karnal";


        open("/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);
        $("#genterWrapper").$(byText(gender)).click();
        $("#userNumber").setValue(mobileNumber);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-dropdown-container").click();
        $(byText(year)).click();
        $(".react-datepicker__month-dropdown-container").click();
        $(byText(month)).click();
        $(".react-datepicker__day--0" + birthDateDay).click();
        $("#subjectsContainer input").setValue(subjects);
        $(".subjects-auto-complete__menu").$(byText(subjects)).click();
        $("#hobbiesWrapper").$(byText(hobbies)).click();
        $("input#uploadPicture").uploadFile(new File("src/test/resources/" + nameFile));
        $("#currentAddress").setValue(currentAddress);
        $(byText("Select State")).click();
        $(byText(state)).click();
        $("#city").click();
        $(byText(city)).click();
        $("button#submit").click();


        $$(".table-responsive tr").findBy(text("Student Name" + " " + firstName + " " + lastName)).shouldBe(visible);
        $$(".table-responsive tr").findBy(text("Student Email" + " " + email)).shouldBe(visible);
        $$(".table-responsive tr").findBy(text("Gender" + " " + gender)).shouldBe(visible);
        $$(".table-responsive tr").findBy(text("Mobile" + " " + mobileNumber)).shouldBe(visible);
        $$(".table-responsive tr").findBy(text("Date of Birth" + " " + birthDateDay + " " + month + "," + year)).shouldBe(visible);
        $$(".table-responsive tr").findBy(text("Hobbies" + " " + hobbies)).shouldBe(visible);
        $$(".table-responsive tr").findBy(text("Picture" + " " + nameFile)).shouldBe(visible);
        $$(".table-responsive tr").findBy(text("Address" + " " + currentAddress)).shouldBe(visible);
        $$(".table-responsive tr").findBy(text("State and City" + " " + state + " " + city)).shouldBe(visible);
        $$(".table-responsive tr").findBy(text("Subjects" + " " + subjects)).shouldBe(visible);


    }

}