package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGenerator {

    private final List<Integer> balls;

    public LottoGenerator() {
        balls = new ArrayList<>();
    }

    public List<Integer> generateLotto() {

        List<Integer> numbers = generateRandomNumbers();

        for (int i = 0; i < 6; i++) {
            balls.add(numbers.get(i));
        }

        Collections.sort(balls);

        return balls;
    }

    protected List<Integer> generateRandomNumbers() {
        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < 45; i++) {
            numbers.add(i + 1);
        }

        Collections.shuffle(numbers);
        return numbers;
    }

    public List<Integer> getBalls() {
        return balls;
    }
}
