package lotto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class LottoWinTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2,})
    void getDefaultWin(int matchCount) {
        // given
        // when
        LottoWin lottoWin = LottoWin.of(matchCount);

        // then
        assertThat(lottoWin).isEqualTo(LottoWin.DEFAULT);
    }

    @Test
    void getSecondWin() {
        // given
        // when
        LottoWin lottoWin = LottoWin.of(5);

        // then
        assertThat(lottoWin).isEqualTo(LottoWin.SECOND);
    }

    @ParameterizedTest
    @CsvSource({
            "0, 0",
            "1, 0",
            "2, 0",
            "3, 5000",
            "4, 50000",
            "5, 1500000",
            "6, 2000000000",
    })
    void winPriceOf_Default(int matchCount, int winPrice) {
        // given
        // when
        Money money = LottoWin.winPriceOf(matchCount);

        // then
        assertThat(money).isEqualTo(new Money(winPrice));
    }

}
