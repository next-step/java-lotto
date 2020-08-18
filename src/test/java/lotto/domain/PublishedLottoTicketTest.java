package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class PublishedLottoTicketTest {

    @ParameterizedTest
    @ValueSource(ints = {10})
    @DisplayName("구매한 갯수 만큼 로또티켓 발행 테스트")
    void publish_lotto_ticket_test(int count) {
        LottoMachine.getInstance();
        PublishedLottoTicket publishedLottoTicket = new PublishedLottoTicket(count);
        assertThat(publishedLottoTicket.getPublishedLottoTicket().size()).isEqualTo(10);
    }

}