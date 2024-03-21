package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoTicket {

    private final List<Integer> balls;
    private final List<Integer> numbers;

    private static final int NUMBERS_OF_BALLS = 6;
    private static final int MAX_NUMBER = 45;

    public LottoTicket(List<Integer> balls, List<Integer> numbers) {
        this.balls = balls;
        this.numbers = numbers;
    }

    public LottoTicket() {
        this(new ArrayList<>(), new ArrayList<>());
    }

    public List<Integer> generate() {
        for (int i = 0; i < NUMBERS_OF_BALLS; i++) {
            this.balls.add(randomNumbers().get(i));
        }
        Collections.sort(this.balls);
        return this.balls;
    }

    protected List<Integer> randomNumbers() {
        for (int i = 0; i < MAX_NUMBER; i++) {
            numbers.add(i + 1);
        }
        Collections.shuffle(numbers);
        return numbers;
    }

    public int countMatchingWith(List<Integer> winningNumbers) {
        return Math.toIntExact(this.balls.stream()
                .filter(winningNumbers::contains)
                .count());
    }

    public List<Integer> getBalls() {
        return balls;
    }

}
