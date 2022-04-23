package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {

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

    public static void validateBonusNumber(Lotto winningLotto, int bonusNumber) {
        if (bonusNumber < MIN_VALID_NUMBER || bonusNumber > MAX_VALID_NUMBER) {
            throw new IllegalArgumentException("bonus number is out of range : " + bonusNumber);
        }
        if (winningLotto.contains(bonusNumber)) {
            throw new IllegalArgumentException("bonus number is already used: " + bonusNumber);
        }
    }

    public double earnings(Lotto winningLotto, int bonusNumber) {
        return findPrize(winningLotto, bonusNumber).getEarnings();
    }

    public Prize findPrize(Lotto winningLotto, int bonusNumber) {
        return Prize.findPrizeByMatchCount(matchCount(winningLotto), contains(bonusNumber));
    }

    private int matchCount(Lotto winningLotto) {
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
