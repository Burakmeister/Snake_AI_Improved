package ai.snake.snakeai;

import ai.snake.snakeai.game.SnakeApplication;
import javafx.application.Application;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
@SpringBootApplication
public class Snake{
    public static void main(String[] args) {
        Application.launch(SnakeApplication.class, args);
    }
}



