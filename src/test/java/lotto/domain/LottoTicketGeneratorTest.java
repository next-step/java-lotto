package lotto.domain;

import lotto.exception.InvalidMoneyInputException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTicketGeneratorTest {

    @ParameterizedTest
    @CsvSource(value = {"1000:1", "50000:50", "2040:2", "3123:3"}, delimiter = ':')
    @DisplayName("입력된 금액으로 살 수 있는 만큼 로또 구매")
    void buyLottoTickets(int money, int count) {
        // given
        LottoTicketGenerator lottoTicketGenerator = new LottoTicketGenerator(new TestGeneratorStrategy());
        // when
        List<LottoTicket> lottoTickets = lottoTicketGenerator.buyLottoTickets(new Money(money));
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
        assertThatThrownBy(() -> lottoTicketGenerator.buyLottoTickets(new Money(money)))
                .isInstanceOf(InvalidMoneyInputException.class);
    }

}