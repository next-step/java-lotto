package dev.dahye.lotto.domain;

import dev.dahye.lotto.util.LottoNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class LottoNumberExtractorTest {
    @Test
    @DisplayName("로또 값 객체가 가지고 있는 값보다 큰 값을 요청하는 경우 IllegalArgumentException throw")
    void valid_lotto_numbers_max_value() {
        assertThrows(IllegalArgumentException.class,
                () -> LottoNumberExtractor.createShuffled(LottoNumbers.MAX_VALUE + 1));
    }
}