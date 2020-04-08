package lotto;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

public class Lotto {

    private static final int LOTTO_SIZE = 6;

    private List<LottoNumber> lottoNumbers;

    public Lotto(List<LottoNumber> numbers) {
        validateLottoNumbers(numbers);
        this.lottoNumbers = Collections.unmodifiableList(numbers);
    }

    private void validateLottoNumbers(List<LottoNumber> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("로또 사이즈가 6이 아님");
        }
        HashSet<LottoNumber> lottoNumbers = new HashSet<>(numbers);
        if (lottoNumbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("로또 번호 중복");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return lottoNumbers.equals(lotto.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }
}
