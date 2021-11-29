package step2;

public class Ball{
    private static final String VALID_BALL_NUMBER_MSG = "로또공의 숫자는 1부터 45사이여야 합니다.";
    private final int number;

    public Ball(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(VALID_BALL_NUMBER_MSG);
        }
        this.number = number;
    }
    public Ball(Ball ball) {
        this.number = ball.number;
    }

    @Override
    public String toString() {
        return number + "";
    }
}
