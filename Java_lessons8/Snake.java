package Java_lessons8;

import java.awt.*;
import java.util.LinkedList;

public class Snake {
    private LinkedList<Cell> snake;
    private int direction;
    private Food food;
    private Poison poison;

    //Сщздание змеи
    public Snake(int x, int y, int length, int direction){
        snake = new LinkedList<>();
        for(int i = 0; i < length; i++){
            snake.add(new Cell(x-i, y, GameSnake.CELL_SIZE, GameSnake.SNAKE_COLOR));
        }
        this.direction = direction;
    }

    //Создание еды
    public void setFood(Food food) {
        this.food = food;
    }

    //Размер змеи
    public int size(){
        return snake.size();
    }

    public void setDirection(int direction){
        //Установка направления движения
        if(Math.abs(this.direction - direction) != 2){
            this.direction = direction;
        }
    }

    //Проверка что змея находится в ячейке x y
    public boolean isInSnake(int x, int y){
        for(Cell cell : snake){
            if (cell.getX() == x && cell.getY() == y){
                return true;
            }
        }
        return false;
    }

    //Создание управления движения змеи
    public void move() {
        //Кооржинаты головы змеи
        int x = snake.getFirst().getX();
        int y = snake.getFirst().getY();
        snake.getFirst().setColor(GameSnake.SNAKE_COLOR); //менчем цвет ячейки, где находится голова

        //Вычисляем новые координаты головы
        switch (direction) {
            case GameSnake.KEY_LEFT: x--;
                if (x < 0)
                    x = GameSnake.CANVAS_WIDTH - 1;
                break;
            case GameSnake.KEY_RIGHT: x++;
                if (x == GameSnake.CANVAS_WIDTH)
                    x = 0;
                break;
            case GameSnake.KEY_UP: y--;
                if (y < 0)
                    y = GameSnake.CANVAS_HEIGHT - 1;
                break;
            case GameSnake.KEY_DOWN: y++;
                if (y == GameSnake.CANVAS_HEIGHT)
                    y = 0;
                break;
        }

        //Если змея сьест яд игра окончена
        if(isInSnake(x, y) ||
                poison.isPoison(x, y)){
            GameSnake.gameOver = true;
            return;
        }

        //Создание головы змеи в новой ячейке
        snake.addFirst(new Cell(x, y, GameSnake.CELL_SIZE, GameSnake.SNAKE_HEAD_COLOR));

        if(food.isFood(x, y)){
            food.eat();
        }else{
            snake.removeLast(); //Убираем хвост
        }

    }

    //Выбор графики
    public void paint(Graphics2D graphics2D){
        for(Cell cell : snake){
            cell.paint(graphics2D);
        }
    }

    public void setPoison(Poison poison) {
        this.poison = poison;
    }
}
