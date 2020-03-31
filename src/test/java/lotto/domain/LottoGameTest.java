package lotto.domain;

import lotto.common.LottoStub;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

class LottoGameTest {

    @DisplayName("구매한 티켓 묶음을 당첨번호와 함께 입력하면 게임 결과를 반환한다")
    @Test
    public void lottoGameMatchTest() {
        LottoMoney lottoMoney = new LottoMoney(1000);
        LottoMachine lottoMachine = new LottoMachine(lottoMoney);

        LottoTickets lottoTickets = lottoMachine.buy(() -> (LottoStub.getLottoNumbers(1, 2, 3, 4, 5, 6)));
        WinningTicket winningTicket = new WinningTicket(LottoStub.getLottoNumbersOneToSix(), 7);

        LottoGame lottoGame = new LottoGame(lottoTickets);
        LottoGameResults lottoGameResults = lottoGame.match(winningTicket);
        BigDecimal winningPrizeSum = lottoGameResults.getWinningPrizeSum();
        
        assertThat(winningPrizeSum.intValue()).isEqualTo(LottoRank.SIX.getWinningPrize());
    }

}
