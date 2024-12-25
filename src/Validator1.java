import java.lang.reflect.Method;

public class Validator1 {
    public static void validate (Object object, Class<?> test) throws Exception {
        Object validator = test.newInstance();
        Method[] methods = test.getDeclaredMethods();
        for (Method method : methods) {
            if (method.getParameterCount() == 1 && method.getParameterTypes()[0].equals(object.getClass())) {
                try {
                    method.invoke(validator, object);
                } catch (Exception e) {
                    throw new ValidateException("ошибка в " + method.getName() + ": " + e.getCause().getMessage());
                }
            }
        }
    }
}