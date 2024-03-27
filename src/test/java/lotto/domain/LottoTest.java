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
        final Set<LottoNumber> validLottoNumbers = lottoNumbers(LOTTO_NUMBERS_SIZE);

        assertThat(Lotto.from(validLottoNumbers))
                .isNotNull();
    }

    @ParameterizedTest
    @ValueSource(ints = {LOTTO_NUMBERS_SIZE - 1, LOTTO_NUMBERS_SIZE + 1})
    @DisplayName("로또 번호가 지정된 개수보다 많거나 적다면 예외를 던진다.")
    void Lotto_MoreOrLessThanSize_Exception(final int invalidSize) {
        final Set<LottoNumber> invalidLottoNumbers = lottoNumbers(invalidSize);

        assertThatIllegalArgumentException()
                .isThrownBy(() -> Lotto.from(invalidLottoNumbers))
                .withMessage(LOTTO_NUMBERS_MUST_HAVE_SPECIFIED_SIZE.message(invalidSize));
    }

    @Test
    @DisplayName("일치하는 로또 번호의 개수를 반환한다.")
    void CountCommonNumbers() {
        final Set<LottoNumber> lottoNumbers = lottoNumbers(LOTTO_NUMBERS_SIZE);
        final Lotto lotto = Lotto.from(lottoNumbers);
        final Lotto otherLotto = Lotto.from(lottoNumbers);

        assertThat(lotto.countCommonNumbers(otherLotto))
                .isEqualTo(LOTTO_NUMBERS_SIZE);
    }

    private Set<LottoNumber> lottoNumbers(final int size) {
        return IntStream.rangeClosed(1, size)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toUnmodifiableSet());
    }
}
