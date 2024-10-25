package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    @DisplayName("로또 숫자 1-45 넘어가는 수에 대한 예외 테스트")
    void 로또_숫자_범위_밖_예외(int input) {

        Assertions.assertThatThrownBy(
                () -> LottoNumber.of(input)
        ).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 범위는 1~45의 범위를 가짐");

    }

}
