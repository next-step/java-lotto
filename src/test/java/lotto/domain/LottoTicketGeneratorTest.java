package lotto.domain;

import lotto.exception.InvalidMoneyInputException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTicketGeneratorTest {

    @Test
    @DisplayName("번호 생성 전략에 따른 로또 티켓 생성")
    void generateLottoTicketsByGenerateStrategy() {
        LottoTicketGenerator lottoTicketGenerator = new LottoTicketGenerator(new TestGeneratorStrategy());
        List<LottoTicket> lottoTickets = lottoTicketGenerator.generateLottoTickets(5);
        Set<LottoNumber> lottoNumbers = Set.of(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6)
        );
        assertThat(lottoTickets).allMatch(ticket -> ticket.equals(new LottoTicket(lottoNumbers)));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 5, 7})
    @DisplayName("input 개수 만큼의 로또 티켓 생성")
    void createLottoTickets(int input) {
        // given
        LottoTicketGenerator lottoTicketGenerator = new LottoTicketGenerator(new TestGeneratorStrategy());
        // when
        List<LottoTicket> lottoTickets = lottoTicketGenerator.generateLottoTickets(input);
        // then
        assertThat(lottoTickets).hasSize(input);
    }

    @ParameterizedTest
    @CsvSource(value = {"1000:1", "50000:50", "2040:2", "3123:3"}, delimiter = ':')
    @DisplayName("입력된 금액으로 살 수 있는 만큼 로또 구매")
    void buyLottoTickets(int money, int count) {
        // given
        LottoTicketGenerator lottoTicketGenerator = new LottoTicketGenerator(new TestGeneratorStrategy());
        // when
        List<LottoTicket> lottoTickets = lottoTicketGenerator.buyLottoTickets(money);
        // then
        assertThat(lottoTickets).hasSize(count);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 50, 500, 999})
    @DisplayName("1000원 이하 입력 시 InvalidInputMoneyException 발생")
    void throwInvalidInputMoneyExceptionTest(int money) {
        // given
        LottoTicketGenerator lottoTicketGenerator = new LottoTicketGenerator(new TestGeneratorStrategy());
        // when, then
        assertThatThrownBy(() -> lottoTicketGenerator.buyLottoTickets(money))
                .isInstanceOf(InvalidMoneyInputException.class);
    }

    @Test
    @DisplayName("생성된 당첨 티켓과 보너스 넘버가 같을 경우 true 반환")
    void returnTrueWhenGeneratedWinningTicketHasSameBonusNumber() {
        LottoTicketGenerator lottoTicketGenerator = new LottoTicketGenerator(new TestGeneratorStrategy());
        WinningTicket winningTicket = lottoTicketGenerator.generateWinningTicket(List.of(1, 2, 3, 4, 5, 6), 7);
        assertThat(winningTicket.isMatchBonusNumber(new LottoNumber(7))).isTrue();
    }

}