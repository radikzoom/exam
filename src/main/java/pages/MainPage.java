package pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;

public class MainPage {

    public SelenideElement cartItem() {return $(".product-container").as("карточка товара");}

    public SelenideElement addToCardButton() {return $("[id=add_to_cart]").as("кнопка добавления");}

    public SelenideElement iconSuccessfully() {return $(".icon-ok").as("Успешное добавление");}

}
