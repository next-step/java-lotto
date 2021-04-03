package lotto.domain;

import lotto.Constant;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final String ERROR_LOTTO_NUM_MSG = "[오류] Lotto 번호 6자리를 입력해주세요.";
    private final String ERROR_NUM_MSG = "[오류] 지난 Lotto가 중복된 번호가있습니다.";

    private final List<Number> lotto;

    public Lotto(List<Number> numbers) {
        checkNumber(numbers);
        this.lotto = numbers.stream()
                .collect(Collectors.toList());
    }

    public int countNumbers(Lotto otherLotto) {
        int count = 0;
        for (Number number : lotto) {
            count += otherLotto.anyMatch(number) ? 1 : 0;
        }
        return count;
    }

    public boolean anyMatch(Number otherNumber) {
        return lotto.contains(otherNumber);
    }

    private void checkNumber(List<Number> numbers) {
        if (numbers.stream().distinct().count() != 6) {
            throw new IllegalArgumentException(ERROR_NUM_MSG);
        }
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ERROR_LOTTO_NUM_MSG);
        }
    }
    public List<Number> getLotto() {
        return lotto;
    }

}
