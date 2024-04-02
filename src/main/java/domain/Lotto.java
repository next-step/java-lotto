package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {

    private final List<Integer> numbers = new ArrayList<>();
    private LottoBall lottoBall;

    public Lotto(List<Integer> balls) {
        for (Integer number : balls) {
            numbers.add(lottoBall.ball(number));
        }
    }

    public int numberCheck(Lotto winNumbers) {
        int cnt = 0;
        for (Integer winNumber : winNumbers.numbers) {
            if (numbers.contains(winNumber))
                cnt++;
        }
        return cnt;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
