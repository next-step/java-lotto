package lotto.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Lotto {

    public static final String LOTTO_NUMBERS_DUPLICATION_EXCEPTION = "로또 숫자에 중복이 존재합니다.";
    public static final String LOTTO_NUMBERS_SIZE_EXCEPTION = "로또를 이루는 숫자가 6개가 아닙니다.";
    public static final int CORRECT_LOTTO_SIZE = 6;
    private final List<LottoNumber> lotto;

    public Lotto(List<Integer> lottoNumbers) {
        validateLotto(lottoNumbers);
        this.lotto = createLotto(lottoNumbers);
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

    private List<LottoNumber> createLotto(List<Integer> lottoNumbers) {
        List<LottoNumber> lotto = new ArrayList<>();
        for (Integer lottoNumber : lottoNumbers) {
            lotto.add(new LottoNumber(lottoNumber));
        }
        return lotto;
    }

    public int countOfMatch(Lotto winnerLotto) {
        return (int) this.lotto.stream()
                .filter(winnerLotto.lotto::contains)
                .count();
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
        return Objects.equals(lotto, lotto1.lotto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lotto);
    }
}
