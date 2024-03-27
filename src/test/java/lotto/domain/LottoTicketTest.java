package lotto.domain;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.SoftAssertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoTicketTest {

    @Test
    @DisplayName("로또 티켓의 번호는 6개이다.")
    void createTicket() {
        LottoTicket lottoTicket = new LottoTicket(List.of(1,2,3,4,5,6));
        assertThat(lottoTicket.getLottoNumbers()).hasSize(6);
    }

    @Test
    @DisplayName("로또 번호가 6개가 아니면 IllegalArgumentException 발생한다.")
    void exception() {

        assertSoftly(softly -> {
            assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new LottoTicket(List.of(1,2,3,4)));
            assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new LottoTicket(List.of(1,2,3,4,5,6,7)));
        });
    }

    @Test
    @DisplayName("보너스 로또 번호를 가지고 있는지 확인한다.")
    void hasBonusNumber() {
        LottoTicket lottoTicket = new LottoTicket(List.of(1,2,3,4,5,6));
        int bonusNumber = 6;

        assertThat(lottoTicket.hasBonusNumber(bonusNumber)).isTrue();
    }

}
