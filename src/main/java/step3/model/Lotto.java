package step3.model;

import static java.lang.String.format;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {

    private static final int LOTTO_NUMBER_SIZE = 6;
    private static final String SIZE_ERROR_MESSAGE = format("로또 번호의 개수는 반드시 %d개 여야 합니다.", LOTTO_NUMBER_SIZE);
    private static final String DUPLICATE_ERROR_MESSAGE = "로또 번호는 중복될 수 없습니다.";

    public static Lotto publishRandom() {
        return new Lotto(LottoNumber.generateRandomNumbers(LOTTO_NUMBER_SIZE));
    }

    private List<LottoNumber> lottoNumbers;

    public Lotto(List<LottoNumber> lottoNumbers) {
        checkSize(lottoNumbers);
        checkNotDuplicate(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private void checkSize(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException(SIZE_ERROR_MESSAGE);
        }
    }

    private void checkNotDuplicate(List<LottoNumber> lottoNumbers) {
        Set<LottoNumber> set = new HashSet<>(lottoNumbers);
        if (set.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException(DUPLICATE_ERROR_MESSAGE);
        }
    }

    public void checkDuplicate(LottoNumber lottoNumber) {
        if (contains(lottoNumber)) {
            throw new IllegalArgumentException(DUPLICATE_ERROR_MESSAGE);
        }
    }

    private boolean contains(LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }

    public List<LottoNumber> getLottoNumbers() {
        return Collections.unmodifiableList(lottoNumbers);
    }

    public LottoReward getReward(Lotto winner, LottoNumber bonusNumber) {
        return LottoReward.of(countMatch(winner), contains(bonusNumber));
    }

    private long countMatch(Lotto other) {
        return lottoNumbers.stream()
            .filter(other::contains)
            .count();
    }
}
