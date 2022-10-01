package com.game.lotto.number;

import static com.game.lotto.number.LottoNumberGenerator.MAX_VALUE_OF_LOTTO_NUMBER;
import static com.game.lotto.number.LottoNumberGenerator.MIN_VALUE_OF_LOTTO_NUMBER;
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
        List<Integer> generatedNumbers = randomLottoNumberGenerator.generateNumbers();
        for (Integer number : generatedNumbers) {
            assertThat(number).isGreaterThanOrEqualTo(MIN_VALUE_OF_LOTTO_NUMBER);
            assertThat(number).isLessThanOrEqualTo(MAX_VALUE_OF_LOTTO_NUMBER);
        }
    }
}