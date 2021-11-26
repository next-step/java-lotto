package step3.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import step3.exception.LottoNumberDuplicateException;
import step3.exception.LottoNumberSizeMismatchException;

public class Lotto {

    public static final int LOTTO_NUMBER_SIZE = 6;

    public static Lotto publishRandom() {
        return new Lotto(LottoNumber.generateRandomNumbers(LOTTO_NUMBER_SIZE));
    }

    private List<LottoNumber> lottoNumbers;

    public Lotto(List<LottoNumber> lottoNumbers) {
        checkSize(lottoNumbers);
        checkDuplicate(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private void checkSize(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_NUMBER_SIZE) {
            throw new LottoNumberSizeMismatchException(lottoNumbers.size());
        }
    }

    private void checkDuplicate(List<LottoNumber> lottoNumbers) {
        Set<LottoNumber> set = new HashSet<>(lottoNumbers);
        if (set.size() != LOTTO_NUMBER_SIZE) {
            throw new LottoNumberDuplicateException(lottoNumbers);
        }
    }

    public void checkDuplicate(LottoNumber lottoNumber) {
        if (contains(lottoNumber)) {
            throw new LottoNumberDuplicateException(lottoNumber);
        }
    }

    private boolean contains(LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }

    public List<LottoNumber> getLottoNumbers() {
        return Collections.unmodifiableList(lottoNumbers);
    }

    public Reward getReward(Lotto winner, LottoNumber bonusNumber) {
        return Reward.of(countMatch(winner), contains(bonusNumber));
    }

    private long countMatch(Lotto other) {
        return lottoNumbers.stream()
            .filter(other::contains)
            .count();
    }

    @Override
    public String toString() {
        return Arrays.toString(lottoNumbers.toArray());
    }
}
