package lotto.domain;

import lotto.pattern.LottoNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoTicketGroupTest {

    @ParameterizedTest()
    @CsvSource(value = {"2100:2", "2000:2"}, delimiter = ':')
    @DisplayName("1000원 단위로 로또를 살 수 있다.")
    void getOneTicket(int money, int ticketCount) {
        LottoTicketGroup lottoTicketGroup = new LottoTicketGroup(money, new LottoNumberGenerator());
        assertThat(lottoTicketGroup.getTickets().size()).isEqualTo(ticketCount);
    }

    @Test
    @DisplayName("1000원 미만을 입력받으면 로또를 구매할 수 없다.")
    void validatePurchaseLotto() {
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoTicketGroup(999, new LottoNumberGenerator()));
    }
}