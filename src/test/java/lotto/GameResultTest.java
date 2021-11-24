package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import lotto.domain.Award;
import lotto.domain.GameResult;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTickets;
import lotto.domain.ResultLotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameResultTest {

    GameResult gameResult;
    int startMoney = 14000;

    @BeforeEach
    void init() {
        int num1 = 1;
        int num2 = 2;
        int num3 = 3;
        int num4 = 41;
        int num5 = 42;

        LottoTickets lottoTickets = new LottoTickets(
            Arrays.asList(mockLottoTicket(num1, num2, num3, 4, 5, 6),
                mockLottoTicket(num1, num2, num3, 4, 5, 6),
                mockLottoTicket(num1, num2, num3, num4, num5, 6),
                mockLottoTicket(num1, num2, num4, 4, 5, 6)));

        ResultLotto resultLotto = new ResultLotto(
            mockLottoTicket(num1, num2, num3, num4, num5, 43));

        gameResult = new GameResult(lottoTickets, resultLotto, startMoney);
    }

    @Test
    @DisplayName(value = "로또의 결과에 따라, 맞추는 결과 갯수가 정상적으로 반환된다.")
    void getResultByCountTest() {
        assertThat(gameResult.getResultByCount(Award.MATCH_OF_THREE)).isEqualTo(3);
        assertThat(gameResult.getResultByCount(Award.MATCH_OF_FOUR)).isEqualTo(0);
        assertThat(gameResult.getResultByCount(Award.MATCH_OF_FIVE)).isEqualTo(1);
    }

    @Test
    @DisplayName(value = "수익률이 정상적으로 출력된다.")
    void getYieldTest() {
        assertThat(gameResult.getYield()).isEqualTo(108.21428571428571);
    }

    LottoTicket mockLottoTicket(int num1, int num2, int num3, int num4, int num5, int num6) {
        return new LottoTicket(Arrays.asList(num1, num2, num3, num4, num5, num6));
    }
}