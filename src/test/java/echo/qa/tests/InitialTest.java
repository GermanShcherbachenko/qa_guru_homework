package echo.qa.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.io.File;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class InitialTest {

    File textFile = new File("src/test/resources/file.txt");

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
    String closeButton = "#closeLargeModal";

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
        $("#genterWrapper").$(byText(genderField)).click();
        $(mobileNumberField).setValue(phone);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("July");
        $(".react-datepicker__year-select").selectOption("1989");
        $("[aria-label$='July 8th, 1989']").click();
        $(subjectsField).setValue(subject).pressEnter();
        $(byText(hobbiesField)).click();
        $(pictureField).uploadFile(textFile);
        $(currentAddressField).setValue(address);
        $(stateField).setValue(state).pressEnter();
        $(cityField).setValue(city).pressEnter();
        $(submitButton).click();

        $("#example-modal-sizes-title-lg").shouldHave(Condition.text("Thanks for submitting the form"));
        $x("//td[contains(., 'Student Name')]/following-sibling::td").shouldHave(Condition.text(name + " " + lastName));
        $x("//td[contains(., 'Student Email')]/following-sibling::td").shouldHave(Condition.text(email));
        $x("//td[contains(., 'Gender')]/following-sibling::td").shouldHave(Condition.text(genderField));
        $x("//td[contains(., 'Mobile')]/following-sibling::td").shouldHave(Condition.text(phone));
        $x("//td[contains(., 'Date of Birth')]/following-sibling::td").shouldHave(Condition.text("08 July,1989"));
        $x("//td[contains(., 'Subjects')]/following-sibling::td").shouldHave(Condition.text(subject));
        $x("//td[contains(., 'Hobbies')]/following-sibling::td").shouldHave(Condition.text(hobbiesField));
        $x("//td[contains(., 'Picture')]/following-sibling::td").shouldHave(Condition.text("file.txt"));
        $x("//td[contains(., 'Address')]/following-sibling::td").shouldHave(Condition.text(address));
        $x("//td[contains(., 'State and City')]/following-sibling::td").shouldHave(Condition.text(state + " " + city));
        $(closeButton).click();
        $(subjectsField).shouldBe(Condition.empty);
    }
}
