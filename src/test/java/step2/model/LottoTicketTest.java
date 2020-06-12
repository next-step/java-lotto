package step2.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTicketTest {

    @DisplayName("정적 생성자는 null을 입력하면 예외 발생")
    @Test
    void createExceptionThrown() {
        assertThatThrownBy(() -> LottoTicket.create(null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력한 로또 개수 반환")
    @Test
    void getTicketCount() {
        LottoTicket lottoTicket = LottoTicket.create(LottoData.createAutoLottos(5));

        assertThat(lottoTicket.getAutoCount()).isEqualTo(5);
    }

    @DisplayName("로또 목록을 변경하면 UnsupportedOperationException 예외 발생")
    @Test
    void getLottoTicketsExceptionThrown() {
        LottoTicket lottoTicket = LottoTicket.create(LottoData.createAutoLottos(5));

        List<Lotto> unmodifiableLottos = lottoTicket.getLottos();

        assertThatThrownBy(() -> unmodifiableLottos.remove(0))
                .isInstanceOf(UnsupportedOperationException.class);
    }
}
