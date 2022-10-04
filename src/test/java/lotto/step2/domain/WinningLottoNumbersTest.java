package lotto.step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class WinningLottoNumbersTest {
    public static final WinningLottoNumbers WINNING_LOTTO_NUMBERS = new WinningLottoNumbers(Arrays.asList(LottoNumberTest.ONE, LottoNumberTest.TWO, LottoNumberTest.THREE, LottoNumberTest.FOUR, LottoNumberTest.FIVE, LottoNumberTest.SIX));
    
    @Test
    @DisplayName("WinningLottoNumbers 객체 생성")
    void create() {
        assertThat(WINNING_LOTTO_NUMBERS).isNotNull();
    }
}