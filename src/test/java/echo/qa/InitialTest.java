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

    File textFile = new File("src/test/java/echo/qa/resources/file.txt");

    String url = "https://demoqa.com/automation-practice-form";

    String name = "Николай";
    String lastName = "Иванов";
    String email = "randomEmail@gmail.com";
    String phone = "9998887766";
    String birthDate = "08 Jun 1989";
    String subject = "Hindi";
    String address = "Рандомная улица в случайном городе";
    String state = "NCR";
    String city = "Noida";

    String header = ".main-header";
    String firstNameField = "#firstName";
    String lastNameField = "#lastName";
    String userEmailField = "#userEmail";
    String genderField = "Male";
    String mobileNumberField = "#userNumber";
    String dateOfBirthField = "#dateOfBirthInput";
    String subjectsField = "#subjectsInput";
    String hobbiesField = "Sports";
    String pictureField = "#uploadPicture";
    String currentAddressField = "#currentAddress";
    String stateField = "#react-select-3-input";
    String cityField = "#react-select-4-input";
    String submitButton = "#submit";

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void firstTest() {
        open(url);
        $(header).shouldHave(Condition.text("Practice Form"));
        $(firstNameField).setValue(name);
        $(lastNameField).setValue(lastName);
        $(userEmailField).setValue(email);
        $(byText(genderField)).click();
        $(mobileNumberField).setValue(phone);
        $(dateOfBirthField).sendKeys(Keys.CONTROL + "a");
        $(dateOfBirthField).sendKeys(birthDate, Keys.ENTER);
        $(subjectsField).sendKeys(subject);
        $(subjectsField).pressEnter();
        $(byText(hobbiesField)).click();
        $(pictureField).uploadFile(textFile);
        $(currentAddressField).setValue(address);
        $(stateField).sendKeys(state);
        $(stateField).pressEnter();
        $(cityField).sendKeys(city);
        $(cityField).pressEnter();
        $(submitButton).click();






    }
}
