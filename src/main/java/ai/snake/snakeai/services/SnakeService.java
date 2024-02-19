package ai.snake.snakeai.services;

import ai.snake.snakeai.game.Field;
import ai.snake.snakeai.game.Snake;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class SnakeService {
    Snake snake;
    public SnakeService() {
        snake = Snake.getInstance();
        snake.restart();
    }
    public Field[][] getFields(){
        return snake.getFields();
    }

    public void step(){
        snake.step();
    }

    public void restart(){
        snake.restart();
    }
    public void getMove(String direction){
        if (direction == "UP") {
            snake.changeDirection(Direction.UP);
        } else if (direction == "DOWN") {
            snake.changeDirection(Direction.DOWN);
        } else if (direction == "LEFT") {
            snake.changeDirection(Direction.LEFT);
        } else {
            snake.changeDirection(Direction.RIGHT);
        }
    }
}

