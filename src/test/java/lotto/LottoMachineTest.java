package lotto;

import lotto.domain.LottoMachine;
import lotto.domain.LottoTicket;
import lotto.domain.WinningLottoTicket;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class LottoMachineTest {

    @Test
    @DisplayName("구입한 금액 확인 가능")
    void buyLottoPrice() {
        LottoMachine lottoMachine = new LottoMachine(10000);

        List<LottoTicket> lottoTickets = lottoMachine.getLottoTickets();

        assertThat(lottoTickets).hasSize(10);
    }

    @Test
    @DisplayName("로또 구입 금액 정합성 체크")
    void validLottoPrice() {

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    // when
                    LottoMachine lottoMachine = new LottoMachine(500);
                }).withMessageContaining("구매 금액 에러");

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    // when
                    LottoMachine lottoMachine = new LottoMachine(1500);
                }).withMessageContaining("구매 금액 에러");
    }

    @Test
    @DisplayName("로또 당첨번호를 저장 할 수 있다.")
    void saveWinningLottoNumber() {
        LottoMachine lottoMachine = new LottoMachine(1000);

        int testBounsNumber = 7;
        lottoMachine.saveWinningNumber(new LottoTicket("1,2,3,4,5,6"), testBounsNumber);

        WinningLottoTicket winningLottoTicket = lottoMachine.getWinningLottoNumbers();

        assertThat(winningLottoTicket.getWinningLottoNumbers())
                .hasSize(6)
                .contains(1, 2, 3, 4, 5, 6);

        assertThat(winningLottoTicket.getBounsNumber()).isEqualTo(testBounsNumber);
    }

    @Test
    @DisplayName("당첨통계를 낼 수 있다. 금액편")
    void statisticsAmount() {

    }

    @Test
    @DisplayName("당첨통계를 낼 수 있다. 수익률편")
    void aggregationOfReturns() {

    }

}
