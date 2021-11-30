package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketsTest {

    @DisplayName("가격에 맞는 로또티켓을 발행한다.")
    @Test
    void createLottoTickets() {
        // given
        Price price = Price.of("14000");

        // when
        LottoTickets lottoTickets = LottoTickets.publishTickets(price);

        // then
        assertThat(lottoTickets.size()).isEqualTo(price.getNumberOfTickets());
    }


}
