package lotto.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.utils.NumberStrategy;

public class Lotto {

    private List<LottoNumber> lottoNumber;

    private static final int LOTTO_NUMBER_SIZE = 6;

    public Lotto(NumberStrategy numberStrategy) {
        setLottoNumber(numberStrategy);
    }

    private void setLottoNumber(NumberStrategy numberStrategy) {
        final List<LottoNumber> numbers = numberStrategy.lottoNumbers();
        checkNumbers(numbers);
        this.lottoNumber = numbers;
    }

    public List<LottoNumber> getLottoNumber() {
        return Collections.unmodifiableList(lottoNumber);
    }

    private void checkNumbers(List<LottoNumber> numbers) {
        if (!(numbers.size() == LOTTO_NUMBER_SIZE)) {
            throw new IllegalStateException("로또 숫자는 6개 입니다.");
        }
        Set<LottoNumber> set = new HashSet<>(numbers);
        if (set.size() < LOTTO_NUMBER_SIZE) {
            throw new IllegalStateException("로또 숫자는 중복되지 않는 6자리 수여야 합니다.");
        }
    }

}
