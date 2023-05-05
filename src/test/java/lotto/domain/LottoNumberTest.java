package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LottoNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 45})
    void 정적팩토리메서드를_검증한다(int number) {
        //given

        //when & then
        assertDoesNotThrow(() -> {
            LottoNumber.of(number);
        });
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    void 정적팩토리메서드에_범위가_맞지않는_숫자를_넣으면_예외가_발생한다(int number) {
        //given

        //when & then
        assertThatThrownBy(() -> {
            LottoNumber.of(number);
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(String.format("범위에 맞지 않는 수입니다. 입력한 수: %d", number));
    }
}
