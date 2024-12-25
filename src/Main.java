import java.util.Scanner;
import static java.lang.System.out;
import java.lang.reflect.Method;
import java.lang.reflect.Field;

public class Main {
    public static void main(String[] args) throws Exception{
        Scanner in = new Scanner(System.in);
        //задние 1
//        out.print("Задание 1(Валидация)\n");
//
//        Human h1 = new Human("Иван","м",750);
//        out.println(h1);
//        Validator1.validate(h1, HumanTests.class);
//
//        Human h2 = new Human("Иван","и",100);
//        out.println(h2);
//        Validator1.validate(h2, HumanTests.class);
//
//        Human h3 = new Human("","м",50);
//        out.println(h3);
//        Validator1.validate(h3, HumanTests.class);
//
//        Human h4 = new Human("Иван","м",45);
//        out.println(h4);
//        Validator1.validate(h4, HumanTests.class);
//
//        //задание 2
        out.println("\nЗадание 2");
        //1
        out.println("Аннотация @Invoke");
        Method[] methods = AnnotationTest.class.getDeclaredMethods();
        // Проверка, есть ли у методов аннотация @Invoke
        for (Method method : methods) {
            if (method.isAnnotationPresent(Invoke.class)) {
                method.invoke(new AnnotationTest());
            }
        }
        //2
        out.println("\nАннотация @Default");
        Class<AnnotationTest> clazz = AnnotationTest.class;
        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(Default.class)) {
                Default fieldAnnotation = field.getAnnotation(Default.class);
                System.out.println("Поле " + field.getName() + " имеет аннотацию @Default с value = " + fieldAnnotation.value().getSimpleName());
            }
        }
        Class<?>[] classes = {Validator1.class, AnnotationTest.class};
        for (Class<?> cls : classes) {
            if (cls.isAnnotationPresent(Default.class)) {
                Default validate = cls.getAnnotation(Default.class);
                out.println("Класс: " + cls.getSimpleName() + "\nАннотация @Default найдена с value: " + validate.value().getSimpleName());
            } else {
                out.println("Класс: " + cls.getSimpleName());
                out.println("Аннотация @Default не найдена");
            }
        }
        //3
        out.println("\nАннотация @ToString");
        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(ToString.class)) {
                ToString fieldAnnotation = field.getAnnotation(ToString.class);
                System.out.println("Поле " + field.getName() + " имеет аннотацию @ToString с value = " + fieldAnnotation.value());
            }
        }
        for (Class<?> cls : classes) {
            if (cls.isAnnotationPresent(ToString.class)) {
                ToString validate = cls.getAnnotation(ToString.class);
                out.println("Класс: " + cls.getSimpleName() + "\nАннотация @ToString найдена с value: " + validate.value());
            } else {
                out.println("Класс: " + cls.getSimpleName());
                out.println("Аннотация @ToString не найдена");
            }
        }
        //4
        out.println("\nАннотация @Validate");
        for (Class<?> cls : classes) {
            if (cls.isAnnotationPresent(Validate.class)) {
                Validate validate = cls.getAnnotation(Validate.class);
                Class<?>[] classes2 = validate.value();
                out.println("Класс: " + cls.getSimpleName() + "\nАннотация @Validate найдена c массивом классов:");
                for (Class<?> cls2 : classes2) {
                    out.print(" " + cls2.getSimpleName());
                }
            } else {
                out.println("Класс: " + cls.getSimpleName());
                out.println("Аннотация @Validate не найдена");
            }
        }
        //5
        out.println("\nАннотация @Two");
        for (Class<?> cls : classes) {
            if (cls.isAnnotationPresent(Two.class)) {
                Two two = cls.getAnnotation(Two.class);
                System.out.println("Класс: " + cls.getSimpleName() + "\nАннотация @Two найдена");
                System.out.println("first: " + two.first());
                System.out.println("second: " + two.second());
            } else {
                System.out.println("Класс: " + cls.getSimpleName() + "\nАннотация @Two не найдена");
            }
        }
        //6
        out.println("\nАннотация @Cache");
        for (Class<?> cls : classes) {
            if (cls.isAnnotationPresent(Cache.class)) {
                Cache cache = cls.getAnnotation(Cache.class);
                out.println("Класс: " + cls.getSimpleName() + "\nАннотация @Cache найдена\nCache значения:" );
                for (String value : cache.value()) {
                    out.println(value);
                }
            } else {
                out.println("Класс: " + cls.getSimpleName() + "\nАннотация @Cache не найдена");
            }
        }
//        //задние 3
//        out.print("Задание 3(Валидация)\nПроверка следующих объектов:");
//        Object[] test = new Object[3];
//        test[0]=new Human("Иван","м",45);
//        test[1]=new Human("Мария","ж",35);
//        test[2]=new AnnotationTest(1,2,3,4);
//        for (Object t : test) {
//            out.println("\n"  + t);
//        }
//        Validator3.validate(test);
//
//        Human h1 = new Human("Иван","м",750);
//        Human h2 = new Human("Иван","и",100);
//        Human h3 = new Human("","м",50);
//        Human h4 = new Human("Иван","м",45);
//        Human[] humans = {h4, h2, h3, h1};
//        for (Human h : humans) {
//            out.println("\n"  + h);
//        }
//        Validator3.validate(humans);

    }
}