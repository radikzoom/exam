package pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;

public class PersonalInformationPage {

    public SelenideElement oldPasswordInput() {return $("[id=old_passwd]").as("Поле ввода старого пароля");}

    public SelenideElement newPasswordInput() {return $("[id=passwd]").as("Поле ввода нового пароля");}

    public SelenideElement confirmPasswordInput() {return $("[id=confirmation]").as("Поле ввода подтеврждения нового пароля");}

    public SelenideElement savePasswordButton() {return $("[name=submitIdentity]").as("Кнопка потверждения пароля");}

    public SelenideElement errorMessage() {return $(".alert.alert-danger").as("Сообщение об ошибке");}

}
