package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;

class LottoResultTest {

    @ParameterizedTest
    @DisplayName("로또 당첨 등수를 기록한다")
    @EnumSource(value = LottoRank.class, names = {"MISS", "FOURTH", "THIRD", "SECOND", "FIRST"})
    void addRanks(LottoRank lottoRank) {
        LottoResult lottoResult = new LottoResult();
        lottoResult.addRanks(List.of(lottoRank));

        Map<LottoRank, Integer> statistics = lottoResult.totalWinningStatistics();

        assertThat(statistics.get(lottoRank)).isEqualTo(1);
    }

    @Test
    @DisplayName("로또 3등 4등 당첨이 되었다")
    void calculateTotalWinningMoney() {
        LottoResult lottoResult = new LottoResult();
        lottoResult.addRanks(List.of(LottoRank.THIRD, LottoRank.FOURTH));

        assertThat(lottoResult.calculateTotalWinningMoney()).isEqualTo(
            LottoRank.THIRD.money() + LottoRank.FOURTH.money());
    }

    @ParameterizedTest
    @CsvSource("5000,1.0")
    void calculateReturnRate(int totalMoney, double rate) {
        LottoResult lottoResult = new LottoResult();
        lottoResult.addRanks(List.of(LottoRank.FIFTH));

        lottoResult.calculateTotalWinningMoney();
        lottoResult.calculateReturnRate(totalMoney);
        assertThat(lottoResult.returnRate()).isEqualTo(rate);
    }

}