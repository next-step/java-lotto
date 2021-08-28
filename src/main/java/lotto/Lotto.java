package lotto;

import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        checkLottoNumbersSize(numbers);

        this.numbers = numbers;
    }

    private static void checkLottoNumbersSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("로또 번호의 개수는 6개가 들어와야 한다.");
        }
    }

}
