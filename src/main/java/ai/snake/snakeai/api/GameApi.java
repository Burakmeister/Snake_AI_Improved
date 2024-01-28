package ai.snake.snakeai.api;

import ai.snake.snakeai.services.SnakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/snake", produces = {MediaType.APPLICATION_JSON_VALUE})
public class GameApi {
    final private SnakeService snakeService;

    @Autowired
    public GameApi(SnakeService snakeService){
        this.snakeService = snakeService;
    }
}
