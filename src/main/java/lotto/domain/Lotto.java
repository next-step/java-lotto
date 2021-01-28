package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private static final int LOTTO_NUMBER_SIZE = 6;

    private final List<Integer> numbers;
    public Lotto(List<Integer> lottoNumbers) {
        checkSizeOfLotto(lottoNumbers);
        checkDuplicatedNumber(lottoNumbers);
        this.numbers = lottoNumbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void checkSizeOfLotto(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException("로또 번호는 6개이어야 합니다.");
        }
    }
    private void checkDuplicatedNumber(List<Integer> lottoNumbers) {
        Set<Integer> lottoNumbersChecker = new HashSet<>(lottoNumbers);
        if(lottoNumbersChecker.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException("중복된 로또번호가 있습니다.");
        }

    }
}
