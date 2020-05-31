package dev.dahye.lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("로또 티켓")
class LottoTicketTest {

    @Test
    @DisplayName("로또 티켓은 6개가 아닌 경우 IllegalArgument Exception throw")
    void validate_lotto_number_size() {
        assertThrows(IllegalArgumentException.class, () -> LottoTicket.manualIssued(Arrays.asList(1, 2, 3, 4, 5)));
    }

    @Test
    @DisplayName("로또 티켓에 중복된 숫자가 들어올 경우 IllegalArgument Exception throw")
    void validate_lotto_number_duplicate() {
        assertThrows(IllegalArgumentException.class, () -> LottoTicket.manualIssued(Arrays.asList(1, 1, 3, 4, 5, 6)));
    }

    @Test
    @DisplayName("로또 티켓은 랜덤한 값이므로 이전에 만들어진 티켓과 동일할 수 없다.")
    void lotto_ticket_random() {
        LottoTicket lottoTicket = LottoTicket.autoIssued();
        LottoTicket comparedLottoTicket = LottoTicket.autoIssued();

        assertThat(lottoTicket.equals(comparedLottoTicket)).isFalse();
    }

}