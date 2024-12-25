import java.lang.reflect.Method;

public class Validator3 {
    public static void validate(Object... objects) throws Exception {
        for (Object object : objects) {
            Class<?> clazz = object.getClass();
            if (clazz.isAnnotationPresent(Validate.class)) {
                Validate validation = clazz.getAnnotation(Validate.class);
                for (Class<?> test : validation.value()) {
                    Object validator = test.newInstance();
                    Method[] methods = test.getDeclaredMethods();
                    for (Method method : methods) {
                        if (method.getParameterCount() == 1 && method.getParameterTypes()[0].equals(clazz)) {
                            try {
                                method.invoke(validator, object);
                            } catch (Exception e) {
                                throw new ValidateException("Ошибка в " + method.getName() + ": " + e.getCause().getMessage());
                            }
                        }
                    }
                }
            } else {
                throw new ValidateException("Класс " + clazz.getSimpleName() + " не аннотирован @Validate");
            }
        }
    }
}

