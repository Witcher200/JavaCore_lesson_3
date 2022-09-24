package lessons_1;

public class RunClass {

    public static void main(String[] args) {
        Person[] person = new Person[4];
        person[0] = new Person("Вася", 130, 3, 49);
        person[1] = new Person("Диана", 200, 4,150);
        person[2] = new Person("Игорь", 150, 5, 85);
        person[3] = new Person("Ангелина", 130, 2, 35);
        Team kom = new Team("Ветерок", person);

        barrier[] barriers = new barrier[5];
        barriers[0] = new barrier (barrier.BarrierType.JumpUP,100);
        barriers[1] = new barrier (barrier.BarrierType.Weight, 25);
        barriers[2] = new barrier (barrier.BarrierType.JumpUP,130);
        barriers[3] = new barrier (barrier.BarrierType.JumpLen,3);
        barriers[4] = new barrier (barrier.BarrierType.Weight, 50);

        Course polosa = new Course(barriers);


        kom.Show();
        polosa.doIt(kom);
        System.out.println("/ / / / /");
        kom.ShowFinished();

        //String result = polosa.doIt(kom);
        //System.out.println(result);

    }
}