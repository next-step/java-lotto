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
        assertThatIllegalArgumentException().isThrownBy(() -> LottoTicket.from(numbers));
    }

    @Test
    void test_uniq_number() {
        assertThatIllegalArgumentException().isThrownBy(() -> LottoTicket.from(1, 1, 2, 3, 4, 5));
    }

    @Test
    void test_is_equal_to() {
        assertThat(LottoTicket.from(1, 2, 3, 4, 5, 6)).isEqualTo(LottoTicket.from(5, 3, 2, 1, 4, 6));
    }

    @Test
    void test_has_number() {
        LottoTicket ticket = LottoTicket.from(1, 2, 3, 4, 5, 6);
        assertThat(ticket.hasNumber(new LottoNumber(1))).isTrue();
        assertThat(ticket.hasNumber(new LottoNumber(7))).isFalse();
    }

    @Test
    void test_get_matching_count() {
        LottoTicket ticket1 = LottoTicket.from(1, 2, 3, 4, 5, 6);
        LottoTicket ticket2 = LottoTicket.from(3, 4, 5, 6, 7, 8);
        assertThat(ticket1.getMatchingCount(ticket2)).isEqualTo(4);
    }
}
