package Java_lessons8;

import java.awt.*;

public class Cell {
    private int x;
    private int y;
    private int size;
    private Color color;

    //Создание ячейки
    public Cell(int x, int y, int size, Color color){
        this.x = x;
        this.y = y;
        this.size = size;
        this.color = color;
    }

    public void set(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void setColor(Color color){
        this.color = color;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    //Вывод на экран ячейки заданного размера и цвета
    public void paint(Graphics2D graphics2D){
        graphics2D.setColor(color);
        graphics2D.fillOval(x * size, y * size, size, size);
        graphics2D.setColor(Color.black); //Чернач рамка овала
        graphics2D.drawOval(x * size, y * size, size, size);
    }
}
