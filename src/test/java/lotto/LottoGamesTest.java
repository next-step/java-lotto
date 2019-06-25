package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGamesTest {

    private String LastWeekWinnerNumber;
    private List<Lotto> lottos;

    @BeforeEach
    void setUp() {
        LastWeekWinnerNumber = "6,13,23,29,35,42";
        lottos = new ArrayList <>();
    }

    @Test
    @DisplayName("총 수익룰 계산 기능 테스트")
    void lottoRateOfReturn() {
        Integer[][] testLottoSet = {
                {6, 13, 23, 30, 36, 43},
                {1, 5, 7, 8, 9, 19},
                {22, 23, 34, 35, 36, 45}
        };
        lottoWinnerCheck(testLottoSet);
        LottoGames lottoGames = new LottoGames(lottos);
        assertThat(lottoGames.rateOfReturn(3000)).isEqualTo(1.66);
    }

    @Test
    @DisplayName("지정된 당첨금액에 맞는 당첨 게임 수 계산 테스트")
    void lottoSummaryWinnerCount() {
        Integer[][] testLottoSet = {
                {6, 13, 23, 30, 36, 43},
                {1, 5, 7, 8, 9, 19},
                {1, 5, 7, 29, 35, 42},
                {6, 13, 23, 29, 36, 45}
        };
        lottoWinnerCheck(testLottoSet);
        LottoGames lottoGames = new LottoGames(lottos);
        assertThat(lottoGames.lottoSummaryWinnerCount(5000)).isEqualTo(2);
        assertThat(lottoGames.lottoSummaryWinnerCount(50000)).isEqualTo(1);
    }

    private void lottoWinnerCheck(Integer[][] testLottoSet) {
        for (Integer[] tempLottos : testLottoSet) {
            List<Integer> lottoNumber = Arrays.asList(tempLottos);
            Lotto lotto = new Lotto(lottoNumber);
            lotto.winnerCheck(LastWeekWinnerNumber);
            lottos.add(lotto);
        }
    }

}
