package camp.nextstep.edu.rebellion.lotto.domain.ticket;

import camp.nextstep.edu.rebellion.lotto.domain.winning.LottoWinningResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketTest {
    @DisplayName("당첨 번호 입력 시 로또 티켓에 있는 로또 번호 만큼 결과가 잘 반환 되는지 확인")
    @Test
    public void matchTest() {
        // given
        int purchaseAmount = 10000;
        String winningNumberInput = "1,2,3,4,5,6";
        LottoTicket lottoTicket = LottoTicketGenerator.purchaseGoodLuck(purchaseAmount);
        LottoWinningNumber winningNumber = new LottoWinningNumber(winningNumberInput);

        // when
        LottoWinningResult result = lottoTicket.match(winningNumber);

        // then
        assertThat(result).isNotNull();
    }
}
