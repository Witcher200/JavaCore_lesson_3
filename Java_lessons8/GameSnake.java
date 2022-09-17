package Java_lessons8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GameSnake extends JFrame {
    final String TITLE_OF_PROGRAM = "Classic Game Snake";
    final String GAME_OVER_MSG = "GAME OVER";
    final static int CELL_SIZE = 20;           // size of cell in pix
    final static int CANVAS_WIDTH = 30;        // width in cells
    final static int CANVAS_HEIGHT = 25;       // height in cells
    final static Color SNAKE_HEAD_COLOR = Color.ORANGE; // snake head color
    final static Color SNAKE_COLOR = Color.green; // snake color
    final static Color FOOD_COLOR = Color.yellow; //food color
    final static Color POISON_COLOR = Color.red;  //poison color
    final static int KEY_LEFT = 37;            // codes
    final static int KEY_UP = 38;              //   of
    final static int KEY_RIGHT = 39;           //   cursor
    final static int KEY_DOWN = 40;            //   keys
    final int START_SNAKE_SIZE = 2;            // initialization data Начальный размер змеи
    final int START_SNAKE_X = CANVAS_WIDTH/2;  //   for
    final int START_SNAKE_Y = CANVAS_HEIGHT/2; //   snake
    final int SNAKE_DELAY = 150;               // snake delay in milliseconds
    int snakeSize = 0;                         // current snake size
    static boolean gameOver = false;           // a sign game is over or not

    Canvas canvas;
    Snake snake;
    Food food;
    Poison poison;

    public GameSnake(){ //Создание окна программы
        setTitle(TITLE_OF_PROGRAM);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        canvas = new Canvas();
        canvas.setBackground(Color.lightGray);
        canvas.setPreferredSize(new Dimension(CELL_SIZE * CANVAS_WIDTH - 1,
                CELL_SIZE * CANVAS_HEIGHT-1));      //с -10 обрезались кружочки справа и снизу
        //Размер игрового поля в пикселях

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                snake.setDirection(e.getKeyCode());
            }
        });

        add(canvas);
        pack();
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    public static void main(String[] args) { //Создание игры
        new GameSnake().game();
    }

    private void game() {  //Создание змеи
        snake = new Snake(
                START_SNAKE_X,
                START_SNAKE_Y,
                START_SNAKE_SIZE,
                KEY_RIGHT
        );
        //Создание еды
        food = new Food(snake);
        snake.setFood(food);
        //Создание яда
        poison = new Poison(snake);
        poison.setFood(food);
        food.setPoison(poison);
        snake.setPoison(poison);

        while(!gameOver){  //Пока не наступил конец игры
            snake.move(); //Движение змеи
            //Проверка увеличения размера змеи
            if (snake.size() > snakeSize){
                snakeSize = snake.size();
                setTitle(TITLE_OF_PROGRAM + ":" + snakeSize);
            }
            //Если еда сьедена добавляем новую еду и яд
            if(food.isEaten()){
                food.appear();
                poison.add();
            }
            canvas.repaint(); //Перерисовка игрового поля
            sleep(SNAKE_DELAY);
        } //При съедении  яда игра окончена
        JOptionPane.showMessageDialog(this, GAME_OVER_MSG + " Длина змеи " + snakeSize);
    }

    private void sleep(long ms){
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    class Canvas extends JPanel {    // class for rendering (drawing)
        @Override
        public void paint(Graphics g) {
            super.paint(g);
            Graphics2D g2D = (Graphics2D) g;
            g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
            snake.paint(g2D);
            food.paint(g2D);
            poison.paint(g2D);
        }
    }
}
