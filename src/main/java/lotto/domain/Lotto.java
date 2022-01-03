package lotto.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.utils.NumberStrategy;

public class Lotto {

    private List<Integer> lottoNumber;

    private static final int LOTTO_NUMBER_SIZE = 6;
    private static final int LOTTO_NUMBER_MIN = 1;
    private static final int LOTTO_NUMBER_MAX = 45;

    public Lotto(NumberStrategy numberStrategy) {
        setLottoNumber(numberStrategy);
    }

    private void setLottoNumber(NumberStrategy numberStrategy) {
        final List<Integer> numbers = numberStrategy.lottoNumbers();
        checkNumbers(numbers);
        this.lottoNumber = numbers;
    }

    public List<Integer> getLottoNumber() {
        return Collections.unmodifiableList(lottoNumber);
    }

    private void checkNumbers(List<Integer> numbers) {
        if (!(numbers.size() == LOTTO_NUMBER_SIZE)) {
            throw new IllegalStateException("로또 숫자는 6개 입니다.");
        }
        Set<Integer> set = new HashSet<>(numbers);
        if (set.size() < LOTTO_NUMBER_SIZE) {
            throw new IllegalStateException("로또 숫자는 중복되지 않는 6자리 수여야 합니다.");
        }
        numbers.stream().forEach(num -> checkNumber(num));
    }

    private void checkNumber(int num) {
        if ((LOTTO_NUMBER_MAX < num) || (num < LOTTO_NUMBER_MIN)) {
            throw new IllegalStateException("로또 숫자는 1에서 45까지 입니다.");
        }
    }


}
