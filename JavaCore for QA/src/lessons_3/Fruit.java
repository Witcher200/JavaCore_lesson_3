package lessons_3;

import javax.management.ObjectName;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Fruit {
// Задание 1
    static String[] arr1 = {"box1", "box2", "box3", "box4"};
    static Integer[] arr2 = {1, 2, 3, 4};
    static Double[] arr3 = {1.2, 2.6, 3.5, 4.2};

    public static void main(String[] args) {

        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
        System.out.println(Arrays.toString(arr3));

        TClass<Object> tclass = new TClass<>();
        tclass.ChangeArr(arr1, 1, 2);
        tclass.ChangeArr(arr2, 0, 3);
        tclass.ChangeArr(arr3, 0, 1);

        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
        System.out.println(Arrays.toString(arr3));

// Задание 2

        ArrayList<Apple> apples = new ArrayList<Apple>(10);
        apples.add(new Apple(1));
        apples.add(new Apple(1));
        apples.add(new Apple(1));
        System.out.println("Apples size " + apples.size());
        System.out.println(apples.toString());

        Box box1 = new Box(apples);
        System.out.println(box1.getWeight());
        box1.showTypes();

        ArrayList<Orange> oranges = new ArrayList<Orange>(10);
        oranges.add(new Orange(1));
        oranges.add(new Orange(1));
        oranges.add(new Orange(1));
        //   oranges.add(new Orange(1));
        System.out.println("Oranges size " + oranges.size());
        System.out.println(oranges.toString());

        Box box2 = new Box(oranges);
        System.out.println(box2.getWeight());
        box2.showTypes();
        System.out.println(box2.Compare(box2));

    }
}





