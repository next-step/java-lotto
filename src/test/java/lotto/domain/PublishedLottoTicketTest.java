package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

class PublishedLottoTicketTest {

    @ParameterizedTest
    @ValueSource(ints = {10, 14, 27})
    @DisplayName("구매한 갯수 만큼 로또 티켓 발행 테스트")
    void publish_lotto_ticket(int count) {
        // given
        PublishedLottoTicket publishedLottoTicket = new PublishedLottoTicket.Builder()
                .autoLottoTicketCount(count)
                .manualLottoNumbers(new ArrayList<>())
                .build();

        // when & then
        assertThat(publishedLottoTicket.getPublishedLottoTicket().size()).isEqualTo(count);
    }

}
