package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTicketGeneratorTest {
    @Test
    @DisplayName("자동으로 로또 번호를 생성")
    void generate_auto() {
        assertThat(LottoTicketGenerator.auto()).isInstanceOf(LottoTicket.class);
    }

    @Test
    @DisplayName("수동으로 로또 티켓 생성 - 성공")
    void generate() {
        int[] numbers = {1, 2, 3, 4, 5, 6};
        assertThat(LottoTicketGenerator.manual(numbers)).isInstanceOf(LottoTicket.class);
    }

    @Test
    @DisplayName("수동(번호 6개)으로 로또 티켓 생성 - 실패")
    void with_over_6_number_count() {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7};
        assertThatThrownBy(() -> LottoTicketGenerator.manual(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LottoTicket.WRONG_NUMBER_COUNT);
    }

    @Test
    @DisplayName("수동(45보다 큰 숫자)으로 로또 티켓 생성 - 실패")
    void with_over_45_number() {
        int[] numbers = {1, 2, 3, 4, 50, 6};
        assertThatThrownBy(() -> LottoTicketGenerator.manual(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LottoNumber.NUMBER_EXCEPTION_MESSAGE);
    }

    @Test
    @DisplayName("수동(중복 숫자)으로 로또 티켓 생성 - 실패")
    void with_duplicate_number() {
        int[] numbers = {1, 2, 3, 4, 6, 6};
        assertThatThrownBy(() -> LottoTicketGenerator.manual(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LottoTicket.DUPLICATE_NUMBER);
    }
}
