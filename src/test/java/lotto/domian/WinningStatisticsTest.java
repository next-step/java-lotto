package lotto.domian;

import lotto.domain.LottoGame;
import lotto.domain.WinningStatistics;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

//        WinningStatistics winningStatistics = new WinningStatistics(testNumberList);
//
//        Map<Integer, Integer> resultLottoGame = winningStatistics.resultLottoGame(lottoGames);
//
//        assertThat(resultLottoGame.get(3).equals(0));
//        assertThat(resultLottoGame.get(4).equals(2));
//        assertThat(resultLottoGame.get(5).equals(1));
//        assertThat(resultLottoGame.get(6).equals(1));
    }
}
