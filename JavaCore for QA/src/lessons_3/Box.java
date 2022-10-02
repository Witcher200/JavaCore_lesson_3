package lessons_3;

import java.util.ArrayList;

public class Box <T extends Fruit>{

    ArrayList<T> Fruit_list;

    public Box(ArrayList<T> obj) {
        this.Fruit_list = obj;
    }

    public double getWeight () {
        double weight;
        if (Fruit_list.get(0).getName()=="Апельсин") weight=1.5f; else weight=1.0F;

        return this.getSize() * weight;
    }

    public int getSize() {
        return this.Fruit_list.size();
    }

    public boolean Compare (Box<? extends Fruit> anotherBox) {
        return this.getWeight() == anotherBox.getWeight();
    }

    public void move_to_Box(Box<T> to_Box){
       System.out.println("Количество фруктов в этой коробке: " + this.getSize());
       System.out.println("Количество фруктов в коробке в которую пересыпаем: " + to_Box.getSize());
       for (int i=0;i<Fruit_list.size();i++){
          to_Box.Fruit_list.add(this.Fruit_list.get(i));
           // System.out.println(Fruit_list.get(i).getName());
       }
       this.Fruit_list.clear();
        System.out.println("После пересыпания: ");
        System.out.println("Количество фруктов в этой коробке: " + this.getSize());
        System.out.println("Количество фруктов в коробке в которую пересыпали: " + to_Box.getSize());
    }

}
