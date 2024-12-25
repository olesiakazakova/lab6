//@Default(value = String.class)
//@ToString()
//@Validate(value = { String.class, Integer.class })
//@Two(first = "Пример", second = 2)
@Cache(value = {"cache1", "cache2"})
public class AnnotationTest {
    //поля
    @Default(value = Integer.class)
    private int field1;
    private int field2;
    @ToString()
    private int field3;
    @ToString(value = ToString.Value.NO)
    private int field4;
    //свойства
    //конструкторы
//    public AnnotationTest (int field1, int field2, int field3, int field4) {
//        this.field1 = field1;
//        this.field2 = field2;
//        this.field3 = field3;
//        this.field4 = field4;
//    }
    //методы
    @Invoke
    public static void methodWithInvoke() {
        System.out.println("Метод с аннотацией @Invoke вызван");
    }
    public static void methodWithoutInvoke() {
        System.out.println("Метод без аннотации @Invoke вызван");
    }
    @Override
    public String toString() {
        return "AnnotationTest:\n" + field1 + " " + field2 + " " + field3 + " " + field4;
    }
}
