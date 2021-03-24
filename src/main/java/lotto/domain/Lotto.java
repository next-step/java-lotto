package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private static final int LOTTO_TOTAL_NUMBER = 6;
    private static final String ERROR_LOTTO_SIZE_MSG = "[오류] 로또 숫자를 다시한번 확인해주세요.";
    List<Number> lotto;

    public Lotto(Numbers numbers) {
        this.lotto = generatorLotto(numbers.getNumbers());
    }

    private List<Number> generatorLotto(List<Number> numbers) {
        Collections.shuffle(numbers);
        return numbers.stream().limit(LOTTO_TOTAL_NUMBER)
                .sorted(Number::compareTo)
                .collect(Collectors.toList());
    }

    public List<Number> getLotto() {
        return lotto;
    }

    public int countNumbers(Lotto otherLotto) {
        int conut = 0;
        for (Number number : lotto) {
            conut += otherLotto.getLotto()
                    .stream()
                    .anyMatch(num -> num.equals(number)) ? 1 : 0;
        }
        return conut;
    }
}
