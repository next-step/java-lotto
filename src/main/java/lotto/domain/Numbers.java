package lotto.domain;

import java.util.TreeSet;
import java.util.List;
import java.util.Set;

import static lotto.constants.Constants.MAX_NUMBER;
import static lotto.constants.Constants.MIN_NUMBER;
import static lotto.constants.Constants.REQUIRED_LOTTO_NUMBERS;

public class Numbers {

    private TreeSet<Integer> numbers;

    public Numbers(List<Integer> numbers) {
        this.numbers = new TreeSet<>(numbers);
        validateLottoNumbers(this.numbers);
    }

    public TreeSet<Integer>  getLottoNumbers() {
        return numbers;
    }

    public static void validateLottoNumbers(Set<Integer> numbers) {
        if (numbers.size() != REQUIRED_LOTTO_NUMBERS) {
            throw new IllegalArgumentException("로또 번호는 서로 다른 " + REQUIRED_LOTTO_NUMBERS + " 개의 번호로 구성되어야 합니다.");
        }

        for (int number : numbers) {
            validateNumber(number);
        }
    }

    public static void validateNumber(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException("잘못된 숫자: " + number + " - 숫자는 " + MIN_NUMBER + " 과 " + MAX_NUMBER + " 사이여야 합니다");
        }
    }

}
