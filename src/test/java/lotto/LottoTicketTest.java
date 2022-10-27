package lotto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoTicketTest {
    @ParameterizedTest
    @ValueSource(ints={5, 7})
    void test_invalid_number_count(int size) {
        int[] numbers = IntStream.rangeClosed(0, size).toArray();
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoTicket(numbers));
    }

    @Test
    void test_is_equal_to() {
        assertThat(new LottoTicket(1, 2, 3, 4, 5, 6)).isEqualTo(new LottoTicket(5, 3, 2, 1, 4, 6));
    }

    @Test
    void test_has_number() {
        LottoTicket ticket = new LottoTicket(1, 2, 3, 4, 5, 6);
        assertThat(ticket.hasNumber(1)).isTrue();
        assertThat(ticket.hasNumber(7)).isFalse();
    }
}
