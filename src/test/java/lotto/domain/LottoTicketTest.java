package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LottoTicketTest {

    @Test
    void 로또_번호_생성() {
        LottoTicket lottoTicket = new LottoTicket();

        System.out.println(lottoTicket);

        // Then
        assertThat(lottoTicket.getLottoNumbers()).hasSize(6);
        assertThat(lottoTicket.getLottoNumbers().stream().allMatch(number -> number >= 1 && number <= 45)).isTrue();
        assertThat(lottoTicket.getLottoNumbers().stream().distinct().count()).isEqualTo(6);
    }
}