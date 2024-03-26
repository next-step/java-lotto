package lotto.domain;

import static lotto.config.LottoExceptionMessage.LOTTO_NUMBERS_MUST_HAVE_SPECIFIED_SIZE;
import static lotto.domain.Lotto.SIZE;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoTest {

    @ParameterizedTest
    @ValueSource(ints = {SIZE - 1, SIZE + 1})
    @DisplayName("로또 번호가 6개보다 많거나 적다면 예외를 던진다.")
    void Lotto_MoreOrLessThanSize_Exception(final int invalidSize) {
        final Set<LottoNumber> numbers = IntStream.rangeClosed(1, invalidSize)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toSet());

        assertThatIllegalArgumentException()
                .isThrownBy(() -> Lotto.from(numbers))
                .withMessage(LOTTO_NUMBERS_MUST_HAVE_SPECIFIED_SIZE.message(numbers.size()));
    }
}
