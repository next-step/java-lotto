package lotto.domain.number;

import static lotto.domain.number.LottoNumbers.LOTTO_NUMBERS_SIZE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import java.util.List;
import lotto.domain.exception.InvalidLottoNumberException;
import lotto.domain.exception.InvalidLottoNumbersSizeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TicketTest {

    @Test
    @DisplayName("정해진 숫자 수 만큼의 숫자를 담은 로또티켓 생성")
    void generate_ticket() {
        Ticket ticket = new Ticket(List.of(1, 2, 3, 4, 5, 6));
        assertThat(ticket.getNumbers()).hasSize(LOTTO_NUMBERS_SIZE);
    }

    @Test
    @DisplayName("정해진 숫자 수랑 다르게 로또티켓을 생성 시도 시 예외 발생.")
    void fail_to_generate_ticket_by_invalid_size() {
        assertThatExceptionOfType(InvalidLottoNumbersSizeException.class)
                .isThrownBy(() -> new Ticket(List.of(1, 2, 3, 4, 5)));
    }

    @Test
    @DisplayName("정해진 범위를 넘어가는 숫자가 포함된 로또티켓 생성 시도 시 예외 발생.")
    void fail_to_generate_ticket_by_invalid_number() {
        assertThatExceptionOfType(InvalidLottoNumberException.class)
                .isThrownBy(() -> new Ticket(List.of(111, 2, 3, 4, 5, 7)));
    }

}
