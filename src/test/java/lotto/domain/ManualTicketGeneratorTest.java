package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ManualTicketGeneratorTest {
    @Test
    void generate() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertThat(ManualTicketGenerator.generate(numbers)).isInstanceOf(LottoTicket.class);
    }

    @Test
    void with_over_6_number_count() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        assertThatThrownBy(() -> ManualTicketGenerator.generate(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LottoTicket.WRONG_NUMBER_COUNT);
    }

    @Test
    void with_over_45_number() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 50, 5, 6);
        assertThatThrownBy(() -> ManualTicketGenerator.generate(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LottoNumber.NUMBER_EXCEPTION_MESSAGE);
    }

    @Test
    void with_duplicate_number() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 6, 6);
        assertThatThrownBy(() -> ManualTicketGenerator.generate(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LottoTicket.DUPLICATE_NUMBER);
    }
}
