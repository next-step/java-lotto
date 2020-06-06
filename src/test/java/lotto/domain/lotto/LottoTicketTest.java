package lotto.domain.lotto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTicketTest {

    @Test
    void 구입_장수만큼_로또번호를_가진다() {
        int quantity = 5;
        LottoTicket lottoTicket = new LottoTicket(quantity);
        assertThat(lottoTicket.getLottoTicket()).size().isEqualTo(quantity);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1})
    void 구입_장수가_0이하인경우(int quantity) {
        assertThatThrownBy(() -> new LottoTicket(quantity))
                .isInstanceOf(IllegalArgumentException.class);
    }

}