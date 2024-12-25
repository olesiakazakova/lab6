public class HumanTests {
    public void testAge(Human human) {
        if (human.getAge() < 1 || human.getAge() > 200) {
            throw new IllegalArgumentException("возраст человека не в диапазоне от 1 до 200");
        }
    }
    public void testName(Human human) {
        if (human.getName() == null || human.getName().isEmpty()) {
            throw new IllegalArgumentException("имя человека не может быть пустым");
        }
    }
    public void testGender(Human human) {
        if (human.getGender() == null || (!human.getGender().equalsIgnoreCase("ж") &&
                !human.getGender().equalsIgnoreCase("м"))) {
            throw new IllegalArgumentException("пол должен быть 'ж' или 'м'");
        }
    }
}
