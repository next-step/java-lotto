package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoNumberTest {
    @ParameterizedTest
    @DisplayName("1~45 범위의 숫자가 아니면 예외를 반환한다.")
    @ValueSource(ints = {0, 46, 50})
    void validateNumberRange_notInRange(int input) {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoNumber(input));
    }

}
