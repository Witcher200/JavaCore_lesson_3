package lessons_3;

import java.util.ArrayList;

public class Box {

    private ArrayList T;

    public Box(ArrayList obj) {
        this.T = obj;
    }

    public void showTypes() {
        System.out.println("Тип: " + T.getClass().getName());
    }

    public int getWeight () {
        return T.size() * 1;
    }

    public boolean Compare (Box anotherzBox) {
        return this.getWeight() == anotherzBox.getWeight();
    }


}
