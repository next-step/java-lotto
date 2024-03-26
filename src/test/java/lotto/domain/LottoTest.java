package lotto.domain;

import static lotto.config.LottoExceptionMessage.LOTTO_NUMBERS_MUST_HAVE_SPECIFIED_SIZE;
import static lotto.domain.Lotto.LOTTO_NUMBERS_SIZE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoTest {

    @Test
    @DisplayName("주어진 로또 번호에 따라 로또를 생성한다.")
    void Lotto_ValidLottoNumbers() {
        final Set<LottoNumber> validLottoNumbers = pickLottoNumbers(LOTTO_NUMBERS_SIZE);

        assertThat(Lotto.from(validLottoNumbers))
                .isNotNull();
    }

    @ParameterizedTest
    @ValueSource(ints = {LOTTO_NUMBERS_SIZE - 1, LOTTO_NUMBERS_SIZE + 1})
    @DisplayName("로또 번호가 지정된 개수보다 많거나 적다면 예외를 던진다.")
    void Lotto_MoreOrLessThanSize_Exception(final int invalidSize) {
        final Set<LottoNumber> invalidLottoNumbers = pickLottoNumbers(invalidSize);

        assertThatIllegalArgumentException()
                .isThrownBy(() -> Lotto.from(invalidLottoNumbers))
                .withMessage(LOTTO_NUMBERS_MUST_HAVE_SPECIFIED_SIZE.message(invalidSize));
    }

    private Set<LottoNumber> pickLottoNumbers(final int size) {
        return IntStream.rangeClosed(1, size)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toSet());
    }
}
