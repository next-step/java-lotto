package step2.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {

    public static final String LOTTO_NUMBERS_DUPLICATE_EXCEPTION_MESSAGE = "로또 숫자는 서로 중복되지 않아야 합니다.";
    public static final String LOTTO_NUMBERS_COUNT_EXCEPTION_MESSAGE = "로또 숫자는 6개로 구성되어야 합니다.";

    private Set<LottoNumber> lotto = new HashSet<>();

    public Lotto(List<LottoNumber> lottoNumbers) {
        assertNumberDuplicate(lottoNumbers);
        assertNumbersCount(lottoNumbers);

        this.lotto = new HashSet<>(lottoNumbers);
    }

    public LottoTier getLottoTier(Lotto targetLotto) {
        return LottoTier.getTier(getMatchingCount(targetLotto));
    }

    private long getMatchingCount(Lotto targetLotto) {
        return lotto.stream()
                .filter(number -> targetLotto.contains(number))
                .count();
    }

    private boolean contains(LottoNumber number) {
        return lotto.contains(number);
    }

    public Set<LottoNumber> getValue() {
        return Collections.unmodifiableSet(lotto);
    }

    private void assertNumberDuplicate(List<LottoNumber> lottoNumbers) {
        Set<LottoNumber> numbers = new HashSet<>(lottoNumbers);

        if(lottoNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(LOTTO_NUMBERS_DUPLICATE_EXCEPTION_MESSAGE);
        }
    }

    private void assertNumbersCount(List<LottoNumber> numbers) {
        if(numbers.size() != 6) {
            throw new IllegalArgumentException(LOTTO_NUMBERS_COUNT_EXCEPTION_MESSAGE);
        }
    }
}
