package ai.snake.snakeai.game;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class StageInitializer implements ApplicationListener<SnakeApplication.StageReadyEvent> {
    private Scene scene;
    private boolean[][] fields = new boolean[30][25];
    private void init(){
        GridPane root = new GridPane(3, 1);
        Pane statsPane = new Pane();
        statsPane.setPrefWidth(250);
        statsPane.setPrefHeight(750);

        Pane gamePane = new Pane();
        gamePane.setPrefWidth(500);
        gamePane.setPrefHeight(750);

        gamePane.setBackground(Background.fill(Color.BLACK));
        statsPane.setBackground(Background.fill(Color.GRAY));
        root.add(gamePane, 0,0, 2, 1);
        root.add(statsPane, 2,0);
        this.scene = new Scene(root, 750, 750);
    }
    @Override
    public void onApplicationEvent(SnakeApplication.StageReadyEvent event) {
        init();
        Stage stage = event.getStage();
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    @Override
    public boolean supportsAsyncExecution() {
        return ApplicationListener.super.supportsAsyncExecution();
    }
}
