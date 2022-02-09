package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {

    private static final int LOTTO_NUMBER_CONDITION = 6;
    private static final String LOTTO_NUMBER_VALIDATION_MESSAGE = "로또는 6개의 숫자입니다";

    private final List<Integer> lottoNumbers;

    public Lotto(List<Integer> lottoNumbers) {
        validateLotto(lottoNumbers);
        Collections.sort(lottoNumbers);
        this.lottoNumbers = new ArrayList<>(lottoNumbers);
    }

    private void validateLotto(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_NUMBER_CONDITION) {
            throw new IllegalArgumentException(LOTTO_NUMBER_VALIDATION_MESSAGE);
        }
    }

    public List<Integer> getNumbers() {
        return lottoNumbers;
    }

    public boolean isContainBonusBall(WinningNumber winningNumber) {
        return winningNumber.isContainBonusBall(lottoNumbers);
    }

    public boolean isContainBonusBall(int bonusBall) {
        return this.lottoNumbers.contains(bonusBall);
    }
}
