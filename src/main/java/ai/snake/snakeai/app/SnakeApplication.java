package ai.snake.snakeai.app;

import ai.snake.snakeai.App;
import ai.snake.snakeai.game.Snake;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventType;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

public class SnakeApplication extends Application {
    private ConfigurableApplicationContext applicationContext;
    private Scene scene;
    private Pane statsPane = new Pane();
    private Canvas canvas;
    private GraphicsContext graphicsContext;
    private Snake snake = Snake.getInstance();

    @Override
    public void init() {
        GridPane root = new GridPane(3, 1);
        statsPane.setPrefWidth(App.FIELD_SIZE * App.HORIZONTAL_FIELDS / 2);
        statsPane.setPrefHeight(App.FIELD_SIZE * App.VERTICAL_FIELDS);

        canvas = new Canvas(App.FIELD_SIZE * App.HORIZONTAL_FIELDS,
                App.FIELD_SIZE * App.VERTICAL_FIELDS);

        statsPane.setBackground(Background.fill(Color.GRAY));
        root.add(canvas, 0,0, 2, 1);
        root.add(statsPane, 2,0);
        this.scene = new Scene(root, App.FIELD_SIZE * App.VERTICAL_FIELDS, App.FIELD_SIZE * App.VERTICAL_FIELDS);
        applicationContext = new SpringApplicationBuilder(App.class).run();
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("Snake");
        graphicsContext = canvas.getGraphicsContext2D();
        canvas.addEventHandler(EventType.ROOT, snake);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void stop() {
        applicationContext.close();
        Platform.exit();
    }

}