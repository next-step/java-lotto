package lotto;

import lotto.domain.LottoNum;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTickets;
import lotto.domain.WinningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import lotto.serivce.LottoService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoServiceTest {
    @DisplayName("로또 500원 구매")
    @Test
    void buyLottoUnder1000Test() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            LottoService.buyTickets(500);
        });
    }

    @DisplayName("로또 1500원 구매")
    @Test
    void buyLotto1500Test() {
        assertThat(LottoService.buyTickets(1500)).hasSize(1);
    }


    @DisplayName("자동 로또 구매")
    @Test
    void buyLottoTest() {
        assertThat(LottoService.buyTickets(14000)).hasSize(14);
    }

    @DisplayName("로또 구매 실패")
    @Test
    void failBuyLottoTest() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            LottoService.buyTickets(0);
        });
    }

    @DisplayName("수동, 자동 로또 구매")
    @Test
    void buyManualLottoTest() {
        List<String> manualLotto = Arrays.asList("1,2,3,4,5,6", "1,3,5,7,9,11");
        assertThat(LottoService.buyTickets(14000, manualLotto).getLottoTickets()).hasSize(14);
    }

    @DisplayName("3개 일치 당첨")
    @Test
    void matchThreeWinnerTest() {
        LottoTicket lottoTicket = LottoTicket.ofString("1,2,3,10,11,12");

        List<LottoTicket> tickets = new ArrayList<>();
        tickets.add(lottoTicket);

        assertThat(LottoService.match(new LottoTickets(tickets), new WinningLotto("1,2,3,4,5,6", new LottoNum(45))).getRanks().sumReward()).isEqualTo(5000);
    }
}
