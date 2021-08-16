package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    @DisplayName("로또 넘버를 생성할 때 1보다 작거나 45보다 큰 값을 입력하면 IllegalArgumentsException이 발생한다.")
    void outOfLottoNumberRange(int number) {
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoNumber(number))
                .withMessage("로또 넘버는 1~45 사이입니다. 입력 로또 넘버 : " + number);
    }
}