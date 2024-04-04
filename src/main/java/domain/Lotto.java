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

    public int numberCheck(Lotto winNumbers) {
        int cnt = 0;
//        for (LottoBall winNumber : winNumbers.numbers) {
//            if (numbers.contains(winNumber))
//                cnt++;
//        }
        for (int i = 0; i < winNumbers.numbers.size() - 1; i++) {
            if (numbers.contains(winNumbers.numbers.get(i)))
                cnt++;
        }
        if (cnt == 5 && numbers.contains(winNumbers.numbers.get(6)))
            return cnt;
        return cnt;
    }

    public List<LottoBall> getNumbers() {
        return numbers;
    }
}
