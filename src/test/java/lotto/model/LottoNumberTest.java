package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {0,-3,46} )
    @DisplayName("예외 : 1부터 45까지의 숫자만 포함된다")
    void boundary_fail(int input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LottoNumber.lottoNumber(input));
    }

    @ParameterizedTest
    @ValueSource(ints = {1,45,30} )
    @DisplayName("예외x : 1부터 45까지의 숫자만 포함된다")
    void boundary_success(int input) {
        assertThatCode(() ->
                LottoNumber.lottoNumber(input)).doesNotThrowAnyException();
    }
}