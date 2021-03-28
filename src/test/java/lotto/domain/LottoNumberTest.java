package lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoNumberTest {
    @ParameterizedTest
    @ValueSource(ints = {1, 45})
    public void of(int expected) {
        assertThat(LottoNumber.of(expected)).isEqualTo(LottoNumber.of(expected));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    public void ofOutOfRange(int expected) {
        assertThatIllegalArgumentException().isThrownBy(() -> LottoNumber.of(expected));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 5, 10})
    public void compareTo(int a) {
        final int b = 5;
        final int expected = Integer.compare(a, 5);

        final int result = LottoNumber.of(a).compareTo(LottoNumber.of(b));

        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void allLottoNumbers() {
        final List<LottoNumber> expected = IntStream.rangeClosed(LottoNumber.MIN_LOTTO_NUMBER, LottoNumber.MAX_LOTTO_NUMBER)
                .mapToObj(LottoNumber::of).collect(Collectors.toList());

        final List<LottoNumber> result = LottoNumber.allLottoNumbers();

        assertThat(result).containsAll(expected);
    }
}
