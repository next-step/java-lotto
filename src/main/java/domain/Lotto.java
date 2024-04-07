package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {

    private final List<LottoBall> balls = new ArrayList<>();

    public Lotto(List<LottoBall> balls) {
        for (int i = 0; i < balls.size(); i++) {
            this.balls.add(balls.get(i));
        }
    }

    private List<Integer> parsed() {
        List<Integer> myBall = new ArrayList<>();
        for (LottoBall ball : balls) {
            myBall.add(ball.getNumber());
        }
        return myBall;
    }

    public int parseNumber(Lotto winNumbers) {
        int cnt = 0;
        List<Integer> myBall = parsed();
        for (int i = 0; i < winNumbers.balls.size(); i++) {
            if (myBall.contains(winNumbers.balls.get(i).getNumber()))
                cnt++;
        }
        if (cnt == 5 && balls.contains(winNumbers.balls.get(6)))
            return 6;
        if (cnt == 6)
            return 7;
        return cnt;
    }

    public List<LottoBall> getBalls() {
        return Collections.unmodifiableList(balls);
    }
}
