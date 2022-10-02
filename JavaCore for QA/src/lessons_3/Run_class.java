package lessons_3;

import java.util.ArrayList;
import java.util.Arrays;

public class Run_class {

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

            ArrayList<Apple> apples = new ArrayList<>(10);
            apples.add(new Apple());
            apples.add(new Apple());
            apples.add(new Apple());
            System.out.println(apples.get(0).getName());

            Box<Apple> box1 = new Box<>(apples);
            System.out.println("Количество яблок: " + box1.getSize());
            System.out.println("Вес яблок: " + box1.getWeight());

            ArrayList<Orange> oranges = new ArrayList<Orange>(10);
            oranges.add(new Orange());
            oranges.add(new Orange()) ;
            oranges.add(new Orange());
            //   oranges.add(new Orange(1));
            System.out.println("Количество апельсинов: " + oranges.size());
            System.out.println(oranges.toString());

            Box<Orange> box2 = new Box<>(oranges);
            System.out.println("Вес апельсинов: " + box2.getWeight());
            System.out.println("Сравнение веса:" + box1.Compare(box2));

            Box<Orange> box3 = new Box<>(new ArrayList<Orange>());
            box2.move_to_Box(box3);
        }

    }

