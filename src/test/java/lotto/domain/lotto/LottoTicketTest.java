package lotto.domain.lotto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class LottoTicketTest {

    @Test
    void 생성_테스트(){
        assertThatCode(()->LottoTicket.create(1)).doesNotThrowAnyException();
    }

    @Test
    void 구입_장수만큼_로또번호를_가진다() {
        int quantity = 5;
        LottoTicket lottoTicket = LottoTicket.create(quantity);
        assertThat(lottoTicket.getLottoTicket()).size().isEqualTo(quantity);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1})
    void 구입_장수가_0이하인경우(int quantity) {
        assertThatThrownBy(() -> LottoTicket.create(quantity))
                .isInstanceOf(IllegalArgumentException.class);
    }

}