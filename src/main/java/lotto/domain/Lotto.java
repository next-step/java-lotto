package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> lottoNumbers;
    private static final int LOTTO_NUMBER_LENGTH = 6;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int MIN_LOTTO_NUMBER = 1;

    public Lotto(List<Integer> lottoNumbers) {
        checkValidLottoNumbers(lottoNumbers);
        checkValidLottoNumberRange(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private void checkValidLottoNumbers(List<Integer> lottoNumbers) {
        Set<Integer> notDuplicatedNumbers = new HashSet<>(lottoNumbers);
        if (notDuplicatedNumbers.size() != LOTTO_NUMBER_LENGTH) {
            throw new IllegalArgumentException("(서로 다른) 로또 번호 6개만 가능합니다.");
        }
    }

    private void checkValidLottoNumberRange(List<Integer> lottoNumbers) {
        lottoNumbers.stream().forEach(i -> checkNumberRange(i));
    }

    private void checkNumberRange(int number) {
        if (number > MAX_LOTTO_NUMBER || number < MIN_LOTTO_NUMBER) {
            throw new IllegalArgumentException("숫자 범위를 초과하였습니다.");
        }
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }
}
