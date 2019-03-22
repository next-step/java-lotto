package domain;

import util.WinType;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import static util.Constants.LOTTO_NUMBER;
import static util.Constants.LOTTO_NUMBER_RANGE_HIGH;

public class Lotto {
    private static final Random RANDOM = new Random();

    private Numbers numbers;
    private Integer bonus;

    private Lotto(Numbers numbers, int bonus) {
        assert isValidBonus(numbers, bonus);

        this.numbers = numbers;
        this.bonus = bonus;
    }

    public static Lotto of(Numbers numbers, int bonus) {
        return new Lotto(numbers, bonus);
    }

    public static Lotto createAuto() {
        return new Lotto(createNumbers(), createBonus());
    }

    boolean isValidBonus(Numbers numbers, int bonus) {
        return !numbers.hasNumber(bonus);
    }

    public WinType figure(Numbers lotteryNumbers) {
        long count = this.numbers.sameNumberCount(lotteryNumbers);
        if (count == WinType.THIRD.getCount() && lotteryNumbers.hasNumber(bonus)) {
            return WinType.SECOND;
        }

        return WinType.findByCount(count);
    }

    public Numbers getNumbers() {
        return this.numbers;
    }

    private static Numbers createNumbers() {
        Set<Integer> numbers = new HashSet<>();
        while (numbers.size() < LOTTO_NUMBER) {
            numbers.add(createBonus());
        }
        int[] numbersArray = numbers.stream().mapToInt(Number::intValue).toArray();

        return Numbers.of(numbersArray);
    }

    private static int createBonus() {
        return RANDOM.nextInt(LOTTO_NUMBER_RANGE_HIGH) + 1;
    }
}
