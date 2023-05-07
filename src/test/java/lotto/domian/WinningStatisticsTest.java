package lotto.domian;

import lotto.domain.LottoGame;
import lotto.domain.WinningStatistics;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningStatisticsTest {

    private List<Integer> testNumberList;

    @BeforeEach
    void setUp() {
        testNumberList = new ArrayList<>();
        testNumberList.add(1);
        testNumberList.add(12);
        testNumberList.add(23);
        testNumberList.add(34);
        testNumberList.add(45);
        testNumberList.add(6);
    }

    @DisplayName("로또 정답 게임 통계를 응답한다.")
    @Test
    public void winningStatisticsTest_정답_게임수_통계_테스트() {
        List<LottoGame> lottoGames = new LottoGameOnlyMake().init();

        WinningStatistics winningStatistics = new WinningStatistics(testNumberList);
        winningStatistics.makeResultMap();;

        Map<Integer, Integer> resultLottoGame = winningStatistics.resultLottoGame(lottoGames);

        assertThat(resultLottoGame.get(3).equals(0));
        assertThat(resultLottoGame.get(4).equals(2));
        assertThat(resultLottoGame.get(5).equals(1));
        assertThat(resultLottoGame.get(6).equals(1));
    }

    @DisplayName("로또 당첨 금액과 구입 금액을 전달하여 수익률을 응답한다.")
    @ParameterizedTest
    @CsvSource(value = {"0:5000:0", "5000:5000:1", "15000:30000:0.5"}, delimiterString = ":")
    public void winningStatisticsTest_정답_게임_수익률_테스트(int totalPrice, int buyPrice, double rate) {
        WinningStatistics winningStatistics = new WinningStatistics(testNumberList);

        assertThat(winningStatistics.calRateOfReturn(totalPrice, buyPrice)).isEqualTo(rate);
    }
}
