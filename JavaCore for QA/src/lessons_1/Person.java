package lessons_1;

public class Person {

    private String name;
    private int canJumpUp;  //Прыжок вверх
    private int canJumpLen; //Прыжок в длину
    private int canGetWeight; //Поднятие веса
    private boolean CourseDone;

    public Person(String name, int canJumpUp, int canJumpLen, int canGetWeight) {
        this.name = name;
        this.canJumpUp = canJumpUp;
        this.canJumpLen = canJumpLen;
        this.canGetWeight = canGetWeight;
        this.CourseDone = false;
    }

    public String getName() {
        return name;
    }

    public int getCanJumpUp() {
        return canJumpUp;
    }

    public int getCanJumpLen() {
        return canJumpLen;
    }

    public int getCanGetWeight() {
        return canGetWeight;
    }

    public boolean getCourseDone() {
        return CourseDone;
    }

    public void setCourseDone() {
        CourseDone = true;
    }

}