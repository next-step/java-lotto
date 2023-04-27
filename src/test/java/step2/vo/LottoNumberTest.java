package step2.vo;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;

public class LottoNumberTest {

    @ParameterizedTest(name = "범위 밖의 숫자가 들어오는 경우 예외 발생하는 테스트")
    @ValueSource(ints = {-1, 0, 46, 100})
    void validateNumberRange_범위_밖_숫자(int number) {
        assertThatCode(() -> new LottoNumber(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("1~45 사이의 숫자만 허용됩니다.");
    }
}
