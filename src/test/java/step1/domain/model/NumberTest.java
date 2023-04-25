package step1.domain.model;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step1.exception.NumberIllegalStateException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;


class NumberTest {

    @ParameterizedTest
    @ValueSource(strings = {"1a","2y","3f","4j","6k","61//",})
    public void 숫자_문자입력시_유효성테스트(String number) {
        assertThatThrownBy(() -> Number.from(number))
                .isInstanceOf(NumberIllegalStateException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1","2","3","4","6","61",})
    public void 숫자_유효성테스트(String number) {
        assertThat(Number.from(number).getNumber())
                .isEqualTo(Integer.parseInt(number));
    }
}
