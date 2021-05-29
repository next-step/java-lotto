package step5.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class LottoNumberTest {

    @DisplayName("1 ~ 45 범위 외의 숫자 입력시 예외 발생 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"-100","0","46"})
    void validNumberRange(int number) {
        assertThatThrownBy(() -> {
            new LottoNumber(number);
        }).isInstanceOf(RuntimeException.class)
                .hasMessageContaining("로또번호는 1~45의 범위입니다.");
    }

}