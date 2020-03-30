package lotto.domain;

import lotto.common.LottoStub;
import lotto.infrastructure.AutoLottoNumberStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class LottoGameTest {

    @DisplayName("로또 게임에 로또 금액을 입력하면 로또 티켓 묶음을 반환한다")
    @ParameterizedTest
    @ValueSource(ints = {10000, 50000})
    public void buyLottoGameTest(int money) {
        LottoMoney lottoMoney = new LottoMoney(money);
        LottoGame lottoGame = new LottoGame(lottoMoney);

        LottoTickets lottoTickets = lottoGame.buy(new AutoLottoNumberStrategy());

        assertThat(lottoTickets).isNotNull();
    }

    @DisplayName("각각의 로또 게임은 같은 금액을 입력했어도 다른 게임으로 취급한다")
    @Test
    public void createLottoGameSameMoneyTest() {
        LottoMoney lottoMoney = new LottoMoney(1000);
        LottoGame lottoGame = new LottoGame(lottoMoney);
        LottoGame otherLottoGame = new LottoGame(lottoMoney);

        assertThat(lottoGame).isNotEqualTo(otherLottoGame);
    }

    @DisplayName("구매한 티켓 묶음을 당첨번호와 함께 입력하면 게임 결과를 반환한다")
    @Test
    public void lottoGameMatchTest() {
        LottoMoney lottoMoney = new LottoMoney(1000);
        LottoGame lottoGame = new LottoGame(lottoMoney);

        LottoTickets lottoTickets = lottoGame.buy(() -> (LottoStub.getLottoNumbers(1, 2, 3, 4, 5, 6)));
        WinningTicket winningTicket = new WinningTicket(LottoStub.getLottoNumbersOneToSix(), 7);
        LottoGameResults lottoGameResults = lottoGame.match(lottoTickets, winningTicket);

        assertThat(lottoGameResults.getWinningPrizeSum()).isEqualTo(LottoRank.SIX.getWinningPrize());
    }
}
