package Java_lessons8;

import java.util.Random;

import static Java_lessons8.GameSnake.*;

public class Food extends Cell{
    private Random random;
    private Snake snake;
    private Poison poison;

    //Подгон размера еды, и размера клетки
    public Food(Snake snake){
        super(-1, -1, GameSnake.CELL_SIZE, FOOD_COLOR);
        random = new Random();
        this.snake = snake;
    }

    //Проверка что в ячейке находится еда
    public boolean isFood(int x, int y){
        return (getX() == x) && (getY() == y);
    }


    public boolean isEaten() {
        return (getX() == -1);
    }

    public void eat(){
        set(-1, -1);
    }

    //Появление еды
    public void appear(){
        int x, y;
        do{
            x = random.nextInt(CANVAS_WIDTH);
            y = random.nextInt(CANVAS_HEIGHT);
        }while(snake.isInSnake(x, y)
                || poison.isPoison(x, y));

        set(x, y);
    }

    public void setPoison(Poison poison) {
        this.poison = poison;
    }
}
