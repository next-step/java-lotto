package lotto.model.winninglotto;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningLottoNumbers {
    private static final int LOTTO_NUMBER_MIN = 1;
    private static final int LOTTO_NUMBER_MAX = 45;
    private static final int LOTTO_SIZE = 6;

    private List<Integer> winningLottoNumbers;

    public WinningLottoNumbers(List<Integer> winningLottoNumbers) {
        validateSize(winningLottoNumbers);
        validateNumberRange(winningLottoNumbers);
        validateDuplication(winningLottoNumbers);
        this.winningLottoNumbers = Collections.unmodifiableList(winningLottoNumbers);
    }

    public List<Integer> getWinningLottoNumbers() {
        return winningLottoNumbers;
    }


    private void validateSize(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("로또는 6개의 숫자로 구성되어야 합니다.");
        }
    }

    private void validateDuplication(List<Integer> lottoNumbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(lottoNumbers);
        if (lottoNumbers.size() > uniqueNumbers.size()) {
            throw new IllegalArgumentException("로또는 중복되지 않은 숫자로 구성되어야 합니다.");
        }
    }

    private void validateNumberRange(List<Integer> lottoNumbers) {
        boolean hasNumberOutOfRange = lottoNumbers.stream()
                .filter(number -> number > LOTTO_NUMBER_MAX || number < LOTTO_NUMBER_MIN)
                .findAny()
                .isPresent();
        if (hasNumberOutOfRange) {
            throw new IllegalArgumentException("로또는 1부터 45까지의 숫자로만 구성되어야 합니다.");
        }
    }
}