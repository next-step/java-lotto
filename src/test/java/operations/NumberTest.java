package operations;

import domain.operations.Number;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

class NumberTest {


    @DisplayName("정수의 문자열을 입력받아서 생성할 수 있다.")
    @Test
    void create() {
        Number number = new Number("1");
        Assertions.assertThat(number.number()).isEqualTo(1);
    }

    @DisplayName("빈문자열일 경우 정수를 입력해달라는 문자열을 반환한다.")
    @ParameterizedTest
    @NullAndEmptySource
    void createAndNullOrEmpty(String str) {
        Assertions.assertThatThrownBy(() -> new Number(str))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("정수를 입력하세요");
    }
}
