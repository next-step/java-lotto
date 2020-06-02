package step2.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTicketsTest {

    @DisplayName("create() 정적 생성자는 null을 입력하면 예외를 발생한다")
    @Test
    void create_Null_ExceptionThrown() {
        assertThatThrownBy(() -> LottoTickets.create(null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("getTicketCount() 메서드는 입력한 티켓 개수를 반환한다")
    @Test
    void getTicketCount_None_TicketCount() {
        LottoTickets lottoTickets = LottoTickets.create(LottoData.createLottoTickets(5));

        assertThat(lottoTickets.getTicketCount()).isEqualTo(5);
    }

    @DisplayName("getLottoTickets() 에서 반환된 로또티켓 리스트를 수정하면 예외가 발생한다")
    @Test
    void getLottoTickets_None_ExceptionThrown() {
        LottoTickets lottoTickets = LottoTickets.create(LottoData.createLottoTickets(5));

        List<LottoTicket> unmodifiableLottoTickets = lottoTickets.getLottoTickets();

        assertThatThrownBy(() -> unmodifiableLottoTickets.remove(0))
                .isInstanceOf(UnsupportedOperationException.class);
    }
}
