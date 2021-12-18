package lotto.domain;

import lotto.exception.LottoException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTicketFactoryTest {

    @DisplayName("돈을 인자로 전달하면 LottoTickets를 살 수 있다. LottoTicket은 한 개에 1000원이다")
    @ParameterizedTest
    @CsvSource(value = {"140000:14", "14300:14", "990:0"}, delimiter = ':')
    void buy() {
        LottoTickets lottoTickets = LottoTicketFactory.buy(14000);
        assertThat(lottoTickets.size()).isEqualTo(14);
    }

    @DisplayName("구입할 금액은 숫자를 입력해야한다. ")
    @Test
    void buyWithMoneyValidation() {
        assertThatThrownBy(() -> LottoTicketFactory.buy("string"))
                .isInstanceOf(LottoException.class);
    }

}