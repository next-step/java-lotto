package lotto.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Lotto {

    protected static final String LOTTO_NUMBERS_DUPLICATION_EXCEPTION = "로또 숫자에 중복이 존재합니다.";
    protected static final String LOTTO_NUMBERS_SIZE_EXCEPTION = "로또를 이루는 숫자가 6개가 아닙니다.";
    protected static final int CORRECT_LOTTO_SIZE = 6;

    private final Set<LottoNumber> lottoNumbers;

    public Lotto(List<Integer> lottoNumbers) {
        validateLotto(lottoNumbers);
        this.lottoNumbers = createLotto(lottoNumbers);
    }

    public Lotto(Integer... lottoNumber) {
        this(List.of(lottoNumber));
    }

    private void validateLotto(List<Integer> lottoNumbers) {
        validateLottoNumbersSize(lottoNumbers);
        validateDuplication(lottoNumbers);
    }

    private void validateLottoNumbersSize(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != CORRECT_LOTTO_SIZE) {
            throw new IllegalArgumentException(LOTTO_NUMBERS_SIZE_EXCEPTION);
        }
    }

    private void validateDuplication(List<Integer> lottoNumbers) {
        Set<Integer> uniqueLottoNumbers = new HashSet<>(lottoNumbers);
        if (uniqueLottoNumbers.size() != CORRECT_LOTTO_SIZE) {
            throw new IllegalArgumentException(LOTTO_NUMBERS_DUPLICATION_EXCEPTION);
        }
    }

    private Set<LottoNumber> createLotto(List<Integer> lottoNumbers) {
        Set<LottoNumber> lotto = new HashSet<>();
        for (Integer lottoNumber : lottoNumbers) {
            lotto.add(new LottoNumber(lottoNumber));
        }
        return lotto;
    }

    public int countOfMatch(Lotto lotto) {
        return (int) this.lottoNumbers.stream()
                .filter(lotto.lottoNumbers::contains)
                .count();
    }

    public Set<LottoNumber> getLotto() {
        return lottoNumbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Lotto lotto1 = (Lotto) o;
        return Objects.equals(lottoNumbers, lotto1.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }
}
