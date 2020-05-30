package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketFactoryTest {

    @DisplayName("자동 로또 번호 객체를 생성할 수 있다.")
    @Test
    void canCreateAutoLottoTickets() {
        List<LottoTicket> autoLottoTickets = LottoTicketFactory.createAutoLottoTickets(5);
        assertThat(autoLottoTickets).isInstanceOf(List.class);
        assertThat(autoLottoTickets.size()).isEqualTo(5);
        autoLottoTickets.forEach(lottoTicket ->
                assertThat(lottoTicket.equalsCreationType(CreationType.AUTO)).isTrue());
    }

    @DisplayName("수동 번호로 객체를 생성할 수 있다.")
    @Test
    void canCreateManualLottoNumbers() {
        LottoTicket lottoTicket = LottoTicketFactory.createManualLottoTicket("1, 2, 3, 4, 5, 6");
        assertThat(lottoTicket).isInstanceOf(LottoTicket.class);
        assertThat(lottoTicket.equalsCreationType(CreationType.MANUAL)).isTrue();
    }
}
