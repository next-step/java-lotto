package lotto.domain;

import lotto.Constant;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private static final String ERROR_OVERLAP_MSG = "[오류] 중복된 값을 입력하셨거나, 6자리를 입력하지 않았습니다..";
    private List<Number> lotto;

    public Lotto(String[] numbers) {
        checkNumber(numbers);
        this.lotto = Arrays.stream(numbers)
                .mapToInt(Integer::parseInt)
                .mapToObj(Number::createNumber)
                .collect(Collectors.toList());
    }

    public Lotto(List<Number> numbers) {
        this.lotto = numbers;
    }

    public int countNumbers(Lotto otherLotto) {
        int conut = 0;
        for (Number number : lotto) {
            conut += otherLotto.anyMatch(number) ? 1 : 0;
        }
        return conut;
    }

    private boolean anyMatch(Number otherNumber) {
        return lotto.contains(otherNumber);
    }

    private void checkNumber(String[] numbers) {
        if (Arrays.stream(numbers).distinct().count() != Constant.LOTTO_TOTAL_NUMBER) {
            throw new IllegalArgumentException(ERROR_OVERLAP_MSG);
        }
    }

    public List<Number> getLotto() {
        return lotto;
    }
}
