import io.qameta.allure.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.params.provider.Arguments.arguments;


@Owner("radikzoom")
@Feature("Авторизация")

public class PasswordChanges {

    @BeforeAll
    static void setup(){
        open("http://automationpractice.com/index.php?controller=authentication&back=my-account");

        TestPages.authenticationPage.emailAddressInput()
                .sendKeys("radikqa@gmail.com");

        TestPages.authenticationPage.passwordInput()
                .sendKeys("K@zantip2022");

        TestPages.authenticationPage.signInButton()
                .click();

        TestPages.authenticationPage.myPersonalInformationButton()
                .click();
    }

    @MethodSource("incorrectPasswordChanges")
    @DisplayName("Провверка изменения пароля с некорректными данными")
    @ParameterizedTest(name = "{displayName} {0} {1}")
    public void shouldNotAuthByIncorrectData(String newPassword, String confPassword) {

        TestPages.personalInformationPage.oldPasswordInput()
                .sendKeys("K@zantip2022");

        step("Заполнить поля ввода нового пароля некорректными данными", () -> {
            TestPages.personalInformationPage.newPasswordInput()
                    .sendKeys(newPassword);

            TestPages.personalInformationPage.confirmPasswordInput()
                    .sendKeys(confPassword);

            TestPages.personalInformationPage.savePasswordButton()
                    .click();
        });

        step("Проверить, что появилась сообщение об ошибке", () -> {
            TestPages.personalInformationPage.errorMessage()
                    .shouldHave(text("There is 1 error"));
        });

    }

    static Stream<Arguments> incorrectPasswordChanges() {
        return Stream.of(
                arguments(
                        "qwewrty",
                        "1234qwerty"
                ),
                arguments(
                        "фывфывыфвыфв",
                        "фывыфвфыв"
                ),
                arguments(
                        "89990000000",
                        "88888888888"
                )
        );
    }
}
