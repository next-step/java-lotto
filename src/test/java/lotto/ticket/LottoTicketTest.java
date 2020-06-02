package lotto.ticket;

import lotto.domain.ticket.LottoTicket;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;


public class LottoTicketTest {

    @Test
    @DisplayName("로또를  생성하는데 어떤 예외도 발생하지 않는다.")
    void 로또_생성_테스트() {
        assertThatCode(() -> LottoTicket.of(Arrays.asList(1, 2, 3, 4, 5, 6))).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("로또 티켓을 생성하는데 크기가 6과 같지 않으면 예외가 발생한다.")
    void 로또_번호_예외_테스트() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LottoTicket.of(Arrays.asList(1, 2, 3, 4, 5)));

        assertThatIllegalArgumentException()
                .isThrownBy(() -> LottoTicket.of(Arrays.asList(1, 2, 3, 4, 5, 7, 9)));
    }

    @Test
    @DisplayName("로또 티켓을 생성하는데 번호가 중복되면 예외가 발생한다.")
    void 로또_번호_중복_예외_테스트() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LottoTicket.of(Arrays.asList(1, 1, 2, 3, 4, 5)));
    }
}
