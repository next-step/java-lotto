package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class LottoResultTest {

    @DisplayName("추첨 결과를 받아서 WinnigSheet 타입을 키로하는 맵을 만든다.")
    @Test
    void createWinningStatistics() {
        LottoMoney lottoMoney = new LottoMoney(3000);
        List<Integer> drawResults = Arrays.asList(3, 4, 6);
        LottoResult lottoResult = new LottoResult(lottoMoney, drawResults);

        Map<WinningSheet, Long> winningStatistics = lottoResult.getWinningStatistics();

        assertAll(
                () -> assertThat(winningStatistics).containsEntry(WinningSheet.FOURTH, 1L),
                () -> assertThat(winningStatistics).containsEntry(WinningSheet.THIRD, 1L),
                () -> assertThat(winningStatistics).containsEntry(WinningSheet.FIRST, 1L),
                () -> assertThat(winningStatistics).containsEntry(WinningSheet.SECOND, 0L)
        );
    }

    @DisplayName("당첨 통계를 바탕으로 총 수익률을 반환한다.")
    @Test
    void calculateRateOfReturn() {
        LottoMoney lottoMoney = new LottoMoney(3000);
        List<Integer> drawResults = Arrays.asList(3, 2, 2);
        LottoResult lottoResult = new LottoResult(lottoMoney, drawResults);

        double rateOfReturn = lottoResult.calculateRateOfReturn();
        assertThat(rateOfReturn).isEqualTo(1.67);
    }
}
