package lotto;

import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        checkLottoNumbersSize(numbers);
        checkDuplicatedNumber(numbers);

        this.numbers = numbers;
    }

    private static void checkLottoNumbersSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("로또 번호의 개수는 6개가 들어와야 한다.");
        }
    }

    private static void checkDuplicatedNumber(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException("로또의 번호는 중복되어 저장될 수 없습니다.");
        }
    }

}
