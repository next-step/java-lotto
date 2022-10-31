package lotto.domain;

import java.util.List;

public class Lotto {
    public static final int MIN = 1;
    public static final int MAX = 45;
    public static final int PRICE = 1000;
    public static final int COUNT = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        checkNumberCount(numbers);
        numbers.forEach(this::checkNumberRange);
        this.numbers = numbers;
    }


    private void checkNumberCount(List<Integer> numbers) {
        int distinctCount = (int) numbers.stream()
                .distinct()
                .count();
        if (distinctCount != COUNT) {
            throw new IllegalArgumentException("로또 숫자는 " + COUNT +"개 선택되어야 합니다.");
        }
    }

    private void checkNumberRange(int number) {
        if (number < MIN || number > MAX) {
            throw new IllegalArgumentException("로또 숫자는 " + MIN + "과 " + MAX + " 사이의 값이어야 합니다");
        }
    }

    public Prize matches(Lotto winNumbers, int bonusNumber) {
        int matchNumber = matchNumberCount(winNumbers);
        boolean hasBonusNumber = hasNumber(bonusNumber);
        return Prize.toPrize(matchNumber, hasBonusNumber);
    }

    private int matchNumberCount(Lotto winNumbers) {
        return (int) numbers.stream()
                .filter(winNumbers.numbers::contains)
                .count();
    }

    public boolean hasNumber(int number) {
        return numbers.contains(number);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
