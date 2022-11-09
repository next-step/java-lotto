package lotto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoNumbersTest {
    @ParameterizedTest
    @ValueSource(ints={5, 7})
    void test_invalid_number_count(int size) {
        int[] numbers = IntStream.rangeClosed(0, size).toArray();
        assertThatIllegalArgumentException().isThrownBy(() -> LottoNumbers.of(numbers));
    }

    @Test
    void test_uniq_number() {
        assertThatIllegalArgumentException().isThrownBy(() -> LottoNumbers.of(1, 1, 2, 3, 4, 5));
    }

    @Test
    void test_is_equal_to() {
        assertThat(LottoNumbers.of(1, 2, 3, 4, 5, 6)).isEqualTo(LottoNumbers.of(5, 3, 2, 1, 4, 6));
    }

    @Test
    void test_has_number() {
        LottoNumbers ticket = LottoNumbers.of(1, 2, 3, 4, 5, 6);
        assertThat(ticket.hasNumber(LottoNumber.of(1))).isTrue();
        assertThat(ticket.hasNumber(LottoNumber.of(7))).isFalse();
    }

    @Test
    void test_get_match_count() {
        LottoNumbers ticket1 = LottoNumbers.of(1, 2, 3, 4, 5, 6);
        LottoNumbers ticket2 = LottoNumbers.of(3, 4, 5, 6, 7, 8);
        assertThat(ticket1.getMatchCount(ticket2)).isEqualTo(4);
    }
}
