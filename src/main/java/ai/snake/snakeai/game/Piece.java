package ai.snake.snakeai.game;

public class Piece {
    protected int x;
    protected int y;

    public Piece(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static void moveToHead(Piece piece, Head head) {
        piece.setX(head.getX());
        piece.setY(head.getY());
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
