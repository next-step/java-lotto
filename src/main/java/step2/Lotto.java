package step2;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {

    public static final String LOTTO_NUMBERS_COUNT_EXCEPTION_MESSAGE = "로또 숫자는 6개로 구성되어야 합니다.";

    private Set<LottoNumber> lottoNumbers = new HashSet<>();

    public Lotto(Set<LottoNumber> lottoNumbers) {
        assertNumbersCount(lottoNumbers);
        this.lottoNumbers = new HashSet<>(lottoNumbers);
    }

    private void assertNumbersCount(Set<LottoNumber> numbers) {
        if(numbers.size() != 6) {
            throw new IllegalArgumentException(LOTTO_NUMBERS_COUNT_EXCEPTION_MESSAGE);
        }
    }
}
