package echo.qa.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class StudentRegistrationFormPage {
    String url = "/automation-practice-form";
    String header = ".main-header";


    SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName");

    public StudentRegistrationFormPage openPage() {
        open(url);
        $(header).shouldHave(Condition.text("Practice Form"));
        return this;
    }
}
