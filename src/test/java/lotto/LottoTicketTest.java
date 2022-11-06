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
        assertThatIllegalArgumentException().isThrownBy(() -> LottoTicket.of(numbers));
    }

    @Test
    void test_uniq_number() {
        assertThatIllegalArgumentException().isThrownBy(() -> LottoTicket.of(1, 1, 2, 3, 4, 5));
    }

    @Test
    void test_is_equal_to() {
        assertThat(LottoTicket.of(1, 2, 3, 4, 5, 6)).isEqualTo(LottoTicket.of(5, 3, 2, 1, 4, 6));
    }

    @Test
    void test_has_number() {
        LottoTicket ticket = LottoTicket.of(1, 2, 3, 4, 5, 6);
        assertThat(ticket.hasNumber(LottoNumber.of(1))).isTrue();
        assertThat(ticket.hasNumber(LottoNumber.of(7))).isFalse();
    }

    @Test
    void test_get_match_count() {
        LottoTicket ticket1 = LottoTicket.of(1, 2, 3, 4, 5, 6);
        LottoTicket ticket2 = LottoTicket.of(3, 4, 5, 6, 7, 8);
        assertThat(ticket1.getMatchCount(ticket2)).isEqualTo(4);
    }
}
