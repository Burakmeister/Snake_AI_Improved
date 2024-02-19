package ai.snake.snakeai.api;

import ai.snake.snakeai.game.Field;
import ai.snake.snakeai.services.SnakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
public class GameApi {
    final private SnakeService snakeService;

    @Autowired
    public GameApi(SnakeService snakeService){
        this.snakeService = snakeService;
    }

    @GetMapping("/fields")
    @ResponseStatus(HttpStatus.OK)
    public Field[][] getFields(){
        return snakeService.getFields();
    }

    @PostMapping("/step")
    @ResponseStatus(HttpStatus.OK)
    public void step(){
        snakeService.step();
    }

    @PostMapping("/restart")
    @ResponseStatus(HttpStatus.OK)
    public void restart(){
        snakeService.restart();
    }

    @PostMapping("/direction")
    @ResponseStatus(HttpStatus.OK)
    public void changeDirection(String direction){
        snakeService.getMove(direction);
    }
}
