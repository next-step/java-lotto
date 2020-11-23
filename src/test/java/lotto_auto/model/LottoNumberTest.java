package lotto_auto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumberTest {

    @DisplayName("잘못된 범위의 번호를 생성했을때 예외 발생 테스트")
    @ParameterizedTest
    @ValueSource(ints = {
            -1,
            -200,
            46
    })
    public void invalidRangeNumberExceptionTest(int number) {
        assertThatThrownBy(
                () -> {
                    LottoNumber lottoNumber = new LottoNumber(number);
                }
        ).isInstanceOf(IllegalArgumentException.class);
    }


}
