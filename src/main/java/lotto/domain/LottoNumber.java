package lotto.domain;

import java.util.List;

public class LottoNumber {

    private final List<Integer> numbers;

    public LottoNumber(Integer... numbers) {
        this(List.of(numbers));
    }

    public LottoNumber(List<Integer> numbers) {
        validation(numbers);
        this.numbers = numbers;
    }

    public int checkLottoNumber(List<Integer> inputNumbers) {
        int count = 0;
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.contains(inputNumbers.get(i))) {
                count++;
            }
        }
        return count;
    }

    private static void validation(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("지난 주 당첨 번호는 6개만 입력해주세요.");
        }
    }

}
