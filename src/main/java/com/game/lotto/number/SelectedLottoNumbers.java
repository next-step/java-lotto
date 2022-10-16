package com.game.lotto.number;

import java.util.List;
import java.util.Optional;

public class SelectedLottoNumbers {
    public static final int LOTTO_NUMBER_SELECT_COUNT = 6;

    private final List<LottoNumber> selectedNumbers;

    public SelectedLottoNumbers(List<LottoNumber> selectedNumbers) {
        isValidNumbers(selectedNumbers);
        this.selectedNumbers = selectedNumbers;
    }

    private void isValidNumbers(List<LottoNumber> numbers) {
        Optional<List<LottoNumber>> nullableNumbers = Optional.ofNullable(numbers);
        if (nullableNumbers.isEmpty() || nullableNumbers.get().size() != LOTTO_NUMBER_SELECT_COUNT) {
            throw new IllegalArgumentException("로또 번호는 " + LOTTO_NUMBER_SELECT_COUNT + "개가 입력되어야 합니다!");
        }
    }

    public List<LottoNumber> getSelectedNumbers() {
        return selectedNumbers;
    }

    @Override
    public String toString() {
        return selectedNumbers.toString();
    }
}
