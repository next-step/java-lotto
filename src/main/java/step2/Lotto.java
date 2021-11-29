package step2;

import java.util.ArrayList;
import java.util.List;

public class Lotto {

    private List<Ball> balls = new ArrayList<>();

    public Lotto(List<Ball> numbers) {
        for (Ball number : numbers) {
            balls.add(new Ball(number));
        }
    }

    @Override
    public String toString() {
        return balls.toString();
    }
}
