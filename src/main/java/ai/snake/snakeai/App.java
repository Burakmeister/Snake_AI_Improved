package ai.snake.snakeai;

import ai.snake.snakeai.app.SnakeApplication;
import javafx.application.Application;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication
public class App {
    public static final int HORIZONTAL_FIELDS = 19;
    public static final int VERTICAL_FIELDS = 29;
    public static final int FIELD_SIZE = 25;
    public static void main(String[] args) {
        Application.launch(SnakeApplication.class, args);
    }
}



