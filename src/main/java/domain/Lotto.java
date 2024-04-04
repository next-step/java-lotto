package domain;

import java.util.ArrayList;
import java.util.List;

public class Lotto {

    private final List<LottoBall> numbers = new ArrayList<>();

    public Lotto(List<LottoBall> balls) {
        for (int i = 0; i < balls.size(); i++) {
            numbers.add(balls.get(i));
        }
    }

    private List<Integer> compare() {
        List<Integer> myBall = new ArrayList<>();
        for (LottoBall ball : numbers) {
            myBall.add(ball.getNumber());
        }
        return myBall;
    }

    public int numberCheck(Lotto winNumbers) {
        int cnt = 0;
        List<Integer> myBall = compare();
        for (int i = 0; i < winNumbers.numbers.size(); i++) {
            if (myBall.contains(winNumbers.numbers.get(i).getNumber()))
                cnt++;
        }
        if (cnt == 5 && numbers.contains(winNumbers.numbers.get(6)))
            return 6;
        if (cnt == 6)
            return 7;
        return cnt;
    }

    public List<LottoBall> getNumbers() {
        return numbers;
    }
}
