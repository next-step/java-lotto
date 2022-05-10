package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketMachineTest {

    @ParameterizedTest
    @CsvSource(value = {"1000:1", "50000:50", "2040:2", "3123:3"}, delimiter = ':')
    @DisplayName("입력된 금액으로 살 수 있는 만큼 로또 구매")
    void buyLottoTickets(int money, int count) {
        // given
        LottoTicketMachine ticketMachine = new LottoTicketMachine();
        // when
        List<LottoTicket> lottoTickets = ticketMachine.buyLottoTickets(new Money(money), new TestGeneratorStrategy());
        // then
        assertThat(lottoTickets).hasSize(count);
    }

    @Test
    @DisplayName("전략에 따른 로또 티켓 구매")
    void buyLottoTicketsByStrategyTest() {
        // given
        LottoTicketMachine ticketMachine = new LottoTicketMachine();
        // when
        List<LottoTicket> lottoTickets = ticketMachine.buyLottoTickets(new Money(1000), new TestGeneratorStrategy());
        // then
        Set<LottoNumber> lottoNumbers = lottoTickets.get(0).getLottoNumbers();
        assertThat(lottoNumbers).containsExactly(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6));
    }

    @Test
    @DisplayName("생성된 당첨 티켓과 보너스 넘버가 같을 경우 true 반환")
    void returnTrueWhenGeneratedWinningTicketHasSameBonusNumber() {
        LottoTicketMachine lottoTicketMachine = new LottoTicketMachine();
        Set<LottoNumber> lottoNumbers = Set.of(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6));
        WinningTicket winningTicket = lottoTicketMachine.generateWinningTicket(lottoNumbers, new LottoNumber(7));

        assertThat(winningTicket.isMatchBonusNumber(new LottoNumber(7))).isTrue();
    }

}