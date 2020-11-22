package lotto.domain.lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static lotto.domain.lotto.LottoNumber.LOTTO_NUMBER_INVALID_RANGE;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class LottoNumberTest {
    @DisplayName("로또 번호 정상 생성")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 44, 45})
    void of_success(final int number) {
        // when
        final LottoNumber result = LottoNumber.of(number);

        // then
        assertThat(result).isNotNull();
    }

    @DisplayName("로또 번호 invalid")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46})
    void of_fail(final int invalidNumber) {
        // when
        final Throwable thrown = catchThrowable(() -> {
            LottoNumber.of(invalidNumber);
        });
        
        // then
        Assertions.assertThat(thrown).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LOTTO_NUMBER_INVALID_RANGE);
    }
}