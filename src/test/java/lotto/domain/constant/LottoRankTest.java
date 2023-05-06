package lotto.domain.constant;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class LottoRankTest {

    @ParameterizedTest
    @CsvSource({"3,FOURTH", "4,THIRD", "5,SECOND", "6,FIRST"})
    void toWinLottoTest(Integer hitNumber, LottoRank winLotto) {
        assertThat(LottoRank.toWinLotto(hitNumber)).isEqualTo(winLotto);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2})
    void toWinLottoExceptionTest(Integer hitNumber) {
        assertThat(LottoRank.toWinLotto(hitNumber)).isEqualTo(LottoRank.MISS);
    }

    @ParameterizedTest
    @CsvSource({"FIRST,2000000000", "SECOND,1500000", "THIRD,50000", "FOURTH,5000"})
    void getWinningAmountTest(LottoRank winLotto, Integer winningAmount) {
        assertThat(winLotto.getWinningAmount()).isEqualTo(winningAmount);
    }
}