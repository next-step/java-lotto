package lotto.domain;

import lotto.domain.LottoNumber;
import lotto.exception.LottoNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumberTest {

    @ParameterizedTest
    @DisplayName("LottoNumber는 1 ~ 45 사의의 숫자가 아닌경우 exception.")
    @ValueSource(ints = {1, 2, 45})
    void createLottoNumberTest(int number) {
        assertThat(LottoNumber.from(number)).isInstanceOf(LottoNumber.class);
    }

    @ParameterizedTest
    @DisplayName("LottoNumber는 1 ~ 45 사의의 숫자가 아닌경우 exception.")
    @ValueSource(ints = {-1, 0, 46})
    void createLottoNumberExceptionTest(int number) {
        assertThatThrownBy(() -> LottoNumber.from(number)).isInstanceOf(LottoNumberException.class);
    }
}