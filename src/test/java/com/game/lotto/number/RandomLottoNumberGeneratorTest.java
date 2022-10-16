package com.game.lotto.number;

import static com.game.lotto.number.LottoNumber.MAX_VALUE_OF_LOTTO_NUMBER;
import static com.game.lotto.number.LottoNumber.MIN_VALUE_OF_LOTTO_NUMBER;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class RandomLottoNumberGeneratorTest {

    private RandomLottoNumberGenerator randomLottoNumberGenerator;

    @BeforeEach
    void set_up() {
        randomLottoNumberGenerator = new RandomLottoNumberGenerator();
    }

    @Test
    void random_number_generation() {
        List<LottoNumber> generatedNumbers = randomLottoNumberGenerator.generateNumbers().getSelectedNumbers();
        for (LottoNumber number : generatedNumbers) {
            assertThat(number.getNumber()).isGreaterThanOrEqualTo(MIN_VALUE_OF_LOTTO_NUMBER);
            assertThat(number.getNumber()).isLessThanOrEqualTo(MAX_VALUE_OF_LOTTO_NUMBER);
        }
    }
}