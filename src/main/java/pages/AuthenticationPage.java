package pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;

public class AuthenticationPage {

    public SelenideElement emailAddressInput() {return $("[id=email]").as("Поле ввода почты");}

    public SelenideElement passwordInput() {return $("[id=passwd]");}

    public SelenideElement signInButton() {return $("[id=SubmitLogin]");}

    public SelenideElement myPersonalInformationButton() {return $(".icon-user").as("Кнопка Мои персональные данные");}

}
