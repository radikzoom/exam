import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Condition.visible;
import static io.qameta.allure.Allure.step;

public class addToCart {

    @Test
    public void addItemToCart(){

        step("Открываем ресурс", () ->
                open("http://automationpractice.com/"));

        step("Добавляем товар в корзину", () -> {
            TestPages.mainPage.cartItem()
                    .click();
            TestPages.mainPage.addToCardButton()
                    .click();
        });

        step("Проверка добавления в корзину", () -> {
            TestPages.mainPage.iconSuccessfully()
                    .shouldBe(visible);
        });
    }
}
