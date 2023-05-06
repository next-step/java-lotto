package lotto.domain.constant;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class WinLottoTest {

    @ParameterizedTest
    @CsvSource({"3,FOURTH", "4,THIRD", "5,SECOND", "6,FIRST"})
    void toWinLottoTest(Integer hitNumber, WinLotto winLotto) {
        assertThat(WinLotto.toWinLotto(hitNumber)).isEqualTo(winLotto);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 7})
    void toWinLottoExceptionTest(Integer hitNumber) {
        assertThatThrownBy(() -> WinLotto.toWinLotto(hitNumber))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource({"FIRST,2000000000", "SECOND,1500000", "THIRD,50000", "FOURTH,5000"})
    void getWinningAmountTest(WinLotto winLotto, Integer winningAmount) {
        assertThat(winLotto.getWinningAmount()).isEqualTo(winningAmount);
    }
}