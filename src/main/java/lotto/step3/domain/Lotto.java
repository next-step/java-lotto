package lotto.step3.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Lotto {

    private static final int LOTTO_NUMBER = 45;
    private static final int LOTTO_SIZE = 6;
    public static final int FIVE_MATCH = 5;

    private static final List<Integer> indices = createIndices();


    private List<Integer> numbers = new ArrayList<>();

    public Lotto() {
        createRandomNumber();
    }

    public Lotto(List<Integer> numbers) {
        checkNumbers(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public boolean isCountOfMatch(Lotto winningNumbers, int count) {
        return numbers.stream()
                .filter(winningNumbers.getNumbers()::contains)
                .count() == count;
    }

    public boolean isSecondPrizeWinner(Lotto winningNumbers, int bonusBall) {
        return isFiveMatch(winningNumbers) && hasBonusBall(bonusBall);
    }

    public int calculatePrizeMoney(Lotto winningNumbers, int bonusBall) {
        int count = (int) numbers.stream()
                .filter(number -> winningNumbers.numbers.contains(number))
                .count();
        return Rank.valueOf(count, isSecondPrizeWinner(winningNumbers,bonusBall)).getPrizeMoney();
    }

    private static List<Integer> createIndices() {
        List<Integer> indices = new ArrayList<>();
        for (int i = 0; i < LOTTO_NUMBER; i++) {
            indices.add(i);
        }
        return indices;
    }

    private void createRandomNumber() {
        while (numbers.size() != LOTTO_SIZE) {
            int randomIndex = new Random().nextInt(LOTTO_NUMBER - 1) + 1;
            addNotDuplicateNumbers(numbers, indices, randomIndex);
        }
        checkNumbers(numbers);
        Collections.shuffle(numbers);
    }

    private void addNotDuplicateNumbers(List<Integer> numbers, List<Integer> indices, int randomIndex) {
        if (!numbers.contains(indices.get(randomIndex))) {
            numbers.add(indices.get(randomIndex));
        }
    }

    private boolean isFiveMatch(Lotto winningNumbers) {
        return numbers.stream()
                .filter(number -> winningNumbers.numbers.contains(number))
                .count() == FIVE_MATCH;
    }

    private boolean hasBonusBall(int bonusBall) {
        return numbers.contains(bonusBall);
    }

    private void checkNumbers(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("6자리 입력 해주세요!!");
        }
        numbers.forEach(n -> {
                    if (!(1 <= n && n <= 45)) {
                        throw new IllegalArgumentException("1~45 숫자를 입력해주세요!!");
                    }});
    }

}
