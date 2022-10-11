package operator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class OperatorTest {

    @ParameterizedTest
    @CsvSource(value = {"+:6", "-:2", "*:8", "/:2"}, delimiter = ':')
    @DisplayName("Operator.execute 는 부호마다 할당된 계산 식을 실행한다.")
    void execute(final String sign, final int expected) {
        Operator operator = Operator.findBySign(sign);
        assertThat(operator.execute(4, 2)).isEqualTo(expected);
    }

    @Test
    @DisplayName("Operator.DEVIDE 는 결과 값이 정수로 떨어지는 값이 아니라면 실패한다.")
    void execute_failToDivide() {
        assertThatThrownBy(() -> {
            Operator.DIVIDE.execute(5, 3);
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessage("결과 값이 정수로 떨어지는 값만 계산 가능합니다.");
    }

    @Test
    @DisplayName("Operator.findBySign 메소드는 넘겨지는 부호 값과 일치하는 Operator를 반환한다.")
    void findBySign() {
        assertThat(Operator.findBySign("+")).isEqualTo(Operator.ADD);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("Operator.findBySign 메소드에 넘겨지는 부호 값이 null 이나 빈 값이면 실패한다.")
    void execute_withNullAndEmpty(final String sign) {
        assertThatThrownBy(() -> {
            Operator.findBySign(sign);
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessage("부호가 누락되었습니다.");
    }

    @Test
    @DisplayName("Operator.findBySign 메소드에 넘겨지는 부호 값이 등록되지 않은 부호면 실패한다.")
    void execute_withWrongSign() {
        assertThatThrownBy(() -> {
            Operator.findBySign("x");
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessage("잘못된 부호입니다.");
    }
}
