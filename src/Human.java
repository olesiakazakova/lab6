@Validate(value = {HumanTests.class})//к заданию 3
public class Human {
    //поля
    private int age;
    private String name;
    private String gender;
    //конструктор
    public Human(String name, String gender, int age) {
        this.age = age;
        this.name = name;
        this.gender = gender;
    }
    //свойства
    public int getAge() {
        return age;
    }
    public String getName() {
        return name;
    }
    public String getGender() {
        return gender;
    }
    //методы
    @Override
    public String toString() {
        return ("Имя: " + name + "\nВозраст: " + age + "\nПол: " + gender);
    }
}
