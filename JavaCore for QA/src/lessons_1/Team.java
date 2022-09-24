package lessons_1;

public class Team {

    private String name;
    private Person[] peoples;

    public Team(String name, Person[] peoples) {
        this.name = name;
        this.peoples = peoples;
    }

    public String getName() {
        return name;
    }

    public Person[] getPeoples() {
        return peoples;
    }

    public void Show() {
        System.out.println("Полный Список участников");
        for (Person person : getPeoples()) {
            System.out.println("Участник: " + person.getName());
            System.out.println("Прыгает в высоту " + person.getCanJumpUp() + " м");
            System.out.println("Прыгает в длинну " + person.getCanJumpLen() + " м");
            System.out.println("Поднимает вес " + person.getCanGetWeight() + " кг");
            System.out.println("Дистанция пройдена " + person.getCourseDone());
            System.out.println("_____");
        }
    }
       public void ShowFinished() {
           System.out.println("Список прощедших полосу");
            for (Person person : getPeoples()) {
                if (person.getCourseDone()) {
                    System.out.println("Участник: " + person.getName());
                }
            }
       }

}