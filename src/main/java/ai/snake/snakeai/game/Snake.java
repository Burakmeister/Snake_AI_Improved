package ai.snake.snakeai.game;

import ai.snake.snakeai.App;
import ai.snake.snakeai.services.Direction;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public final class Snake implements EventHandler {
    private static final Snake instance = new Snake();
    private Field[][] fields;
    private Piece apple;
    private Head head = new Head();
    private List<Piece> pieces;
    private int snakeLength;
    private Direction snakeDirection;

    private Snake(){
        fields = new Field[App.VERTICAL_FIELDS][App.HORIZONTAL_FIELDS];
        pieces = new ArrayList<>();
        snakeLength = 0;
        snakeDirection = Direction.DOWN;
    }
    public static Snake getInstance(){
        return instance;
    }

    public void restart(){
        Head head = new Head();
        snakeLength = 0;
        snakeDirection = Direction.DOWN;
        Arrays.stream(fields).forEach(row -> {
            for(int i=0; i<App.HORIZONTAL_FIELDS; i++){
                row[i] = Field.NONE;
            }
        });
        fields[App.VERTICAL_FIELDS/2][App.HORIZONTAL_FIELDS/2] = Field.HEAD;
        generateApple();
        this.head = head;
    }
    public Field[][] getFields(){
        return fields;
    }

    public void changeDirection(Direction direction){
        snakeDirection = direction;
    }

    public void step() {
        fields[head.getX()][head.getY()] = Field.NONE;
        switch (snakeDirection){
            case UP -> {
                head.setY(head.getY()-1);
            }
            case DOWN -> {
                head.setY(head.getY()+1);
            }
            case LEFT -> {
                head.setX(head.getX()-1);
            }
            case RIGHT -> {
                head.setX(head.getX()+1);
            }
        }
        fields[head.getX()][head.getY()] = Field.HEAD;
        int x = head.getX();
        int y = head.getY();
        if(x == apple.getX() && y == apple.getY()){
            fields[x][y] = Field.NONE;
            generateApple();
            snakeLength++;
        }
    }

    public Piece getApple() {
        return apple;
    }

    public Head getHead() {
        return head;
    }

    public List<Piece> getPieces() {
        return pieces;
    }

    public int getSnakeLength() {
        return snakeLength;
    }

    public void render(GraphicsContext graphicsContext){
        graphicsContext.setFill(Color.BLACK);
        graphicsContext.fillRect(0, 0, App.VERTICAL_FIELDS*App.FIELD_SIZE,
                App.HORIZONTAL_FIELDS*App.FIELD_SIZE);

        graphicsContext.setFill(Color.RED);
        graphicsContext.fillRect(apple.getX()*App.FIELD_SIZE, apple.getY()*App.FIELD_SIZE,
                App.FIELD_SIZE, App.FIELD_SIZE);

        graphicsContext.setFill(Color.WHITE);
        graphicsContext.fillRect(head.getX()*App.FIELD_SIZE, head.getY()*App.FIELD_SIZE,
                App.FIELD_SIZE, App.FIELD_SIZE);
    }

    private void generateApple(){
        Random rand = new Random();
        int x, y;
        do{
            x = rand.nextInt(App.VERTICAL_FIELDS);
            y = rand.nextInt(App.HORIZONTAL_FIELDS);
        }while (x == head.getX() || y == head.getY());
        fields[x][y] = Field.APPLE;
        apple = new Piece(x, y);
    }

    @Override
    public void handle(Event event) {

    }
}


