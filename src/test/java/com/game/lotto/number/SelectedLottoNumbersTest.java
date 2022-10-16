package com.game.lotto.number;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SelectedLottoNumbersTest {

    private static final List<LottoNumber> LOTTO_NUMBERS = List.of(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6));

    @Test
    void get_selected_numbers() {
        SelectedLottoNumbers selectedLottoNumbers = new SelectedLottoNumbers(LOTTO_NUMBERS);
        for (int index = 0; index < selectedLottoNumbers.getSelectedNumbers().size(); index++) {
            assertEquals(LOTTO_NUMBERS.get(index), selectedLottoNumbers.getSelectedNumbers().get(index));
        }
    }
}