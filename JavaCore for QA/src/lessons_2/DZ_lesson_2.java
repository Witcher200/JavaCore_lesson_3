package lessons_2;

import java.util.Arrays;

public class DZ_lesson_2 {

    static String[][] array1 = {{"5", "2", "3", "4"}, {"7" , "0", "g", "8"}, {"9", "6", "7", "8"}, {"5", "6", "7", "8"}};
    static String[][] array2 = {{"1", "2", "3", "4"}, {"5" , "6", "7", "8"}, {"9", "6", "7", "8"}, {"5", "6", "7", "8"}};
    static String[][] array3 = {{"6", "2"}, {"5" , "6"}, {"4", "6"}};

    public static class MyArraySizeException extends Exception {
        public MyArraySizeException(String msg){
            super(msg);
        }
    }

    public static class MyArrayDataException extends Exception {
        public MyArrayDataException(String msg) {
            super(msg);
        }
    }

    public static void main(String[] args) {

        try {
            System.out.println("Сумма элементов 1го массива:");
            System.out.println(checkArraySum(array1));
        }
        catch (MyArraySizeException | MyArrayDataException ex){
            System.out.println(ex.getMessage());
        }

        try {
            System.out.println("Сумма элементов 2го массива:");
            System.out.println(checkArraySum(array2));
        } catch (MyArraySizeException | MyArrayDataException ex){
            System.out.println(ex.getMessage());
        }

        try {
            System.out.println("Сумма элементов 3го массива:");
            System.out.println(checkArraySum(array3));
        } catch (MyArraySizeException | MyArrayDataException ex){
            System.out.println(ex.getMessage());
        }
    }

    static Integer checkArraySum(String[][] StrArr) throws MyArraySizeException,MyArrayDataException{
        if (StrArr.length!=4 || StrArr[0].length!=4) {
            throw new MyArraySizeException("Размер массива не 4 на 4");
        }
        Integer summa = 0;
        int i =0;
        int j =0;
        try {
            for (; i < StrArr.length; i++) {
                j =0;
                for (; j < StrArr.length; j++) {
                    System.out.print(StrArr[i][j]+ " ");
                    summa = summa + Integer.parseInt(StrArr[i][j]);
                }
                System.out.println();
            }
        } catch (NumberFormatException ex){
            throw new  MyArrayDataException("Неверные данные в ячейке[" + i+"]["+j+"]");
        }
     return summa;
    }
}
