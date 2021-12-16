package echo.qa;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import io.netty.util.concurrent.NonStickyEventExecutorGroup;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.io.File;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class InitialTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void firstTest() {
        open("https://demoqa.com/automation-practice-form");
        $(".main-header").shouldHave(Condition.text("Practice Form"));
        $("#firstName").setValue("Николай");
        $("#lastName").setValue("Иванов");
        $("#userEmail").setValue("randomEmail@gmail.com");
        $(byText("Male")).click();
        $("#userNumber").setValue("9998887766");
        $("#dateOfBirthInput").sendKeys(Keys.CONTROL + "a");
        $("#dateOfBirthInput").sendKeys("08 Jun 1989", Keys.ENTER);
        $("#subjectsInput").sendKeys("Hindi");
        $("#subjectsInput").pressEnter();
        $(byText("Sports")).click();
        $("#uploadPicture").uploadFile(new File("src/test/java/echo/qa/resources/file.txt"));
        $("#currentAddress").setValue("Рандомная улица в случайном городе");
        $("#react-select-3-input").sendKeys("NCR");
        $("#react-select-3-input").pressEnter();
        $("#react-select-4-input").sendKeys("Noida");
        $("#react-select-4-input").pressEnter();
        $("#submit").click();






    }
}
