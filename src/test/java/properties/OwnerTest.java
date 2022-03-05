package properties;

import config.CredentialsConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static java.lang.String.format;

@DisplayName("Данные из credentials.properties")
@Tag("owner")
public class OwnerTest {
    public CredentialsConfig credentials = ConfigFactory.create(CredentialsConfig.class);

    @Test
    void readCredentionalsTest() {
        step("Читаем и выводим данные из credentials.properties", () -> {
            String login = credentials.login();
            String password = credentials.password();
            String message = format("https://%s:%s@selenoid.autotests.cloud/wd/hub/", login, password);
            System.out.println("Логин: " + login);
            System.out.println("Пароль: " + password);
            System.out.println("Адрес удаленного доступа: " + message);
        });
    }
}
