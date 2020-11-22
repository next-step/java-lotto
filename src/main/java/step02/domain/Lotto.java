package step02.domain;

import exception.DuplicatedLottoNumberException;
import exception.InValidSizeOfLottoException;

import java.util.*;

public class Lotto {
    private static final int LOTTO_NUMBER_COUNT = 6;

    private final SortedSet<LottoNumber> lotto;

    private Lotto(List<LottoNumber> lotto) {
        validateLottoSize(lotto);
        validateUniqueNumber(lotto);
        this.lotto = new TreeSet(lotto);
    }

    public static Lotto of(List<LottoNumber> lotto) {
        return new Lotto(lotto);
    }

    private void validateUniqueNumber(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != new HashSet<>(lottoNumbers).size()) {
            throw new DuplicatedLottoNumberException();
        };
    }

    private static void validateLottoSize(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_NUMBER_COUNT) {
            throw new InValidSizeOfLottoException();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto1 = (Lotto) o;
        return Objects.equals(lotto, lotto1.lotto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lotto);
    }

    public int matchCount(Lotto winningNumbers) {
        int total = 0;
        for(LottoNumber lottoNumber : lotto) {
            if (winningNumbers.lotto.contains(lottoNumber)) {
                total += 1;
            }
        }
        return total;
    }

    public SortedSet<LottoNumber> print() {
        return lotto;
    }
}
