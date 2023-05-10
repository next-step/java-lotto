package lotto.domian;

import lotto.domain.LottoTicket;
import lotto.domain.WinningStatistics;
import lotto.util.RewardTable;
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
        List<LottoTicket> lottoTickets = new LottoGameOnlyMake().init();

        WinningStatistics winningStatistics = new WinningStatistics(testNumberList, 7);

        Map<RewardTable, Long> resultLottoGame = winningStatistics.resultLottoGame(lottoTickets);

        assertThat(resultLottoGame.get(RewardTable.FIFTH_RANK).equals(0));
        assertThat(resultLottoGame.get(RewardTable.FOURTH_RANK).equals(2));
        assertThat(resultLottoGame.get(RewardTable.THIRD_RANK).equals(0));
        assertThat(resultLottoGame.get(RewardTable.SECOND_RANK).equals(1));
        assertThat(resultLottoGame.get(RewardTable.FIRST_RANK).equals(1));
    }
}
