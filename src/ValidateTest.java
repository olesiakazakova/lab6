import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ValidateTest {

    @Test
    // Проверяем, что валидация корректного объекта Human
    // (с корректными значениями имени, пола и возраста)
    // не вызывает исключений и проходит успешно.
    public void testValidHuman() {
        // Объект тестирования: корректный объект Human
        Human validHuman = new Human("Иван", "м", 30);
        // Ожидание: метод validate не выбросит исключение
        assertDoesNotThrow(() -> Validator3.validate(validHuman));
    }

    @Test
    // Проверяем, что валидация объекта Human с некорректным возрастом 300
    // выбрасывает исключение ValidateException с правильным
    // сообщением об ошибке,
    // указывающим на недопустимый возраст (нужно от 1 до 200).
    public void testInvalidAge() {
        // Объект тестирования: объект Human с некорректным возрастом
        Human invalidAgeHuman = new Human("Иван", "м", 300);
        // Ожидание: метод validate выбросит исключение ValidateException
        ValidateException exception = assertThrows(ValidateException.class, () -> Validator3.validate(invalidAgeHuman));
        assertEquals("Ошибка в testAge: возраст человека не в диапазоне от 1 до 200", exception.getMessage());
    }

    @Test
    // Проверяем, что валидация объекта Human с пустым именем
    // выбрасывает исключение ValidateException с соответствующим
    // сообщением об ошибке,
    // указывающим на то, что имя не может быть пустым.
    public void testEmptyName() {
        // Объект тестирования: объект Human с пустым именем
        Human emptyNameHuman = new Human("", "ж", 25);
        // Ожидание: метод validate выбросит исключение ValidateException
        ValidateException exception = assertThrows(ValidateException.class, () -> Validator3.validate(emptyNameHuman));
        assertEquals("Ошибка в testName: имя человека не может быть пустым", exception.getMessage());
    }

    @Test
    // Проверяем, что валидация объекта Human с некорректным значением пола
    // выбрасывает исключение ValidateException с правильным
    // сообщением об ошибке,
    // указывающим на допустимые значения пола (должно быть 'ж' или 'м').
    public void testInvalidGender() {
        // Объект тестирования: объект Human с некорректным полом
        Human invalidGenderHuman = new Human("Оля", "некорректный пол", 22);
        // Ожидание: метод validate выбросит исключение ValidateException
        ValidateException exception = assertThrows(ValidateException.class, () -> Validator3.validate(invalidGenderHuman));
        assertEquals("Ошибка в testGender: пол должен быть 'ж' или 'м'", exception.getMessage());
    }
}


