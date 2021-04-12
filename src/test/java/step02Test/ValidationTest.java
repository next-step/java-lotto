package step02Test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step02.Validation;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidationTest {

    @Test
    @DisplayName("최대 숫자 범위 초과 테스트")
    void overMaxNumber() {
        assertThatThrownBy(() ->
                Validation.overMaxNumber(46))
                .isInstanceOf(Exception.class).hasMessage("로또 숫자는 45이하의 수를 입력해주세요.");
    }

    @ParameterizedTest
    @DisplayName("최대 개수 범위 초과 테스트")
    @ValueSource(ints = {0, 7})
    void overMaxNumberCount() {
        assertThatThrownBy(() ->
                Validation.numberCount(7))
                .isInstanceOf(Exception.class).hasMessage("6개의 수를 입력해주세요.");
    }

    @Test
    void checkMinPrice() {
        assertThatThrownBy(() ->
                Validation.checkMinPrice(500))
                .isInstanceOf(Exception.class).hasMessage("최소 구매 금액은 1000원 입니다.");
    }
}
