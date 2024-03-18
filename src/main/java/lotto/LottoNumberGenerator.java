package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumberGenerator {
    public List<Integer> generateLotto() {
        List<Integer> balls = new ArrayList<>();

        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < 45; i++) {
            numbers.add(i + 1);
        }

        Collections.shuffle(numbers);

        for (int i = 0; i < 6; i++) {
            balls.add(numbers.get(i));
        }

        return balls;
    }
}
