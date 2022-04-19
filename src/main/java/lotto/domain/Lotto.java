package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.Map.*;

public class Lotto {

    public static final Map<Integer, Double> PRIZE = ofEntries(
            entry(0, 0d),
            entry(1, 0d),
            entry(2, 0d),
            entry(3, 5000d),
            entry(4, 50000d),
            entry(5, 1_500_000d),
            entry(6, 2_000_000_000d)
    );

    public static final int LOTTO_PRICE = 1000;
    private static final int MIN_VALID_NUMBER = 1;
    private static final int MAX_VALID_NUMBER = 45;
    private static final int LOTTO_SIZE = 6;
    private static final List<Integer> NUMBER_POOL = IntStream.range(MIN_VALID_NUMBER, MAX_VALID_NUMBER + 1)
            .boxed()
            .collect(Collectors.toList());

    private final List<Integer> numbers;

    public Lotto() {
        Collections.shuffle(NUMBER_POOL);
        this.numbers = new ArrayList<>(NUMBER_POOL.subList(0, LOTTO_SIZE));
    }

    public Lotto(List<Integer> numbers) {
        validateNumbers(numbers);
        this.numbers = numbers;
    }

    private void validateNumbers(List<Integer> numbers) {
        int validNumberCount = numbers.stream()
                .filter(n -> MIN_VALID_NUMBER <= n && n <= MAX_VALID_NUMBER)
                .collect(Collectors.toSet())
                .size();

        if (validNumberCount != LOTTO_SIZE) {
            throw new IllegalArgumentException("invalid lotto numbers");
        }
    }

    public static List<Lotto> createLottosOfSize(int size) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            lottos.add(new Lotto());
        }
        return lottos;
    }

    public double earnings(Lotto winningLotto) {
        return PRIZE.get(matchCount(winningLotto));
    }

    public int matchCount(Lotto winningLotto) {
        return (int) numbers.stream()
                .filter(winningLotto::contains)
                .count();
    }

    private boolean contains(int number) {
        return numbers.contains(number);
    }

    public List<Integer> getNumbers() {
        return new ArrayList<>(numbers);
    }
}
