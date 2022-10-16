package com.game.lotto.number;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ManualLottoNumberGeneratorTest {

    private static final List<LottoNumber> LOTTO_NUMBERS = List.of(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6));

    private ManualLottoNumberGenerator manualLottoNumberGenerator;

    @BeforeEach
    void set_up() {
        manualLottoNumberGenerator = new ManualLottoNumberGenerator(LOTTO_NUMBERS);
    }

    @Test
    void manual_number_generation() {
        SelectedLottoNumbers generatedNumbers = manualLottoNumberGenerator.generateNumbers();
        for (int index = 0; index < generatedNumbers.getSelectedNumbers().size(); index++) {
            assertEquals(LOTTO_NUMBERS.get(index), generatedNumbers.getSelectedNumbers().get(index));
        }
    }
}