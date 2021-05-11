package tests;

import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

@Story("Main page tests")
public class MainPageTests extends TestBase {

    @Test
    @DisplayName("Проверяем первую страницу")
    public void mainPageTests() {
        step("Открываем главную страницу", () -> open("https://www.diasoft.ru/"));
        step("Проверяем наличие логотипа", () -> {
            $("img[src='/local/templates/diasoft_2019/images/logo_new.svg']").shouldBe(visible);
        });

    }

    @Test
    @DisplayName("Переход в раздел О Компании")
    public void goToSection() {
        step("Открываем главную страницу", () -> open("https://www.diasoft.ru/"));
        step("Проверяем переход в раздел О Компании", () -> {
            $(withText("О компании")).click();
        });
    }

    @Test
    @DisplayName("Переход на страницу с EN")
    public void languageTranslation() {
        step("Открываем главную страницу", () -> open("https://www.diasoft.ru/"));
        step("Ищем переход на страницу с английским языком и кликаем на него", () -> {
            $(".lang").shouldBe(visible).click();
        });
    }

    @Test
    @DisplayName("Поиск по сайту")
    public void search() {
        step("Открываем главную страницу", () -> open("https://www.diasoft.ru/"));
        step("Ищем поисковое поле", () -> {
            $(".js-img-search").shouldBe(visible).click();
        });
        step("Задаём поиск", () -> {
            $("#qplSKIW").setValue("Контакты").pressEnter();
        });
        step("Проверяем результаты", () -> {
            $(".breadcrumb-navigation").shouldHave(text("Поиск"));
        });
    }

    @Test
    @DisplayName("Переход ко всем новостям компании")
    public void allCompanyNews() {
        step("Открываем главную страницу", () -> open("https://www.diasoft.ru/"));
        step("Ищем ссылку на переход ко всем новостям", () -> {
            $(".all-news").shouldBe(visible).click();
        });
        step("Проверяем перехода к новостям", () -> {
            $(".breadcrumb-navigation").shouldHave(text("Новости"));
        });
    }
}

