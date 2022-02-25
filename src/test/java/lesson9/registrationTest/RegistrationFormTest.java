package lesson9.registrationTest;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.startMaximized = true;
    }

    @Test
    void FormToFill(){

        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue("Айдана");
        $("#lastName").setValue("Жолдасова");
        $("#userEmail").setValue("user@gmail.com");
        $(byText("Female")).click();
        $("#userNumber").setValue("7777777777");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOptionByValue("6");
        $(".react-datepicker__year-select").selectOptionByValue("1997");
        $(".react-datepicker__day.react-datepicker__day--013").click();
        $("#subjectsInput").click();
        $("#subjectsInput").sendKeys("Ma");
        $(byText("Maths")).click();
        $(byText("Music")).click();
        $("#uploadPicture").uploadFile(new File("src//test//resources//girl.jpg"));
        $("#currentAdress").setValue("Тараз, Баженова 36");
        $("#state").click();
        $(byText("NCR")).click();
        $("#city").click();
        $(byText("Delhi")).click();
        $("#submit").click();

        // проверки
        verifyData("Student Name","Айдана Жолдасова");
        verifyData("Student Email","user@gmail.com");
        verifyData("Gender","Female");
        verifyData("Mobile","77777777777");
        verifyData("Date of Birth","13 June,1997");
        verifyData("Subjects","Math");
        verifyData("Hobbies","Music");
        verifyData("Picture","girl.jpg");
        verifyData("Address","Тараз, Баженова 36");
        verifyData("State and City","NCR Delhi");
    }

    private void verifyData(String label, String value) {
        $(".table-responsive").$(byText(label)).parent().shouldHave(text(value));
    }
}
