package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> lottoNumbers;
    private static final int LOTTO_NUMBER_LENGTH = 6;

    public Lotto(List<Integer> lottoNumbers) {
        checkValidLottoNumbers(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private void checkValidLottoNumbers(List<Integer> lottoNumbers) {
        Set<Integer> notDuplicatedNumbers= new HashSet<>(lottoNumbers);
        if (notDuplicatedNumbers.size() != LOTTO_NUMBER_LENGTH) {
            throw new IllegalArgumentException("(서로 다른) 로또 번호 6개만 가능합니다.");
        }
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }
}
