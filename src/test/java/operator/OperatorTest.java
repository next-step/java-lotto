package operator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

public class OperatorTest {

    @ParameterizedTest
    @CsvSource(value = {"+:6", "-:2", "*:8", "/:2"}, delimiter = ':')
    @DisplayName("Operator.execute 메소드는 입력한 부호의 execute 메소드를 실행한다.")
    void execute(final String sign, final int expected) {
        assertThat(Operator.execute(4, 2, sign)).isEqualto(expected);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("Operator.execute 메소드에 넘겨지는 부호 값이 null 이나 빈 값이면 실패한다.")
    void execute_withNullAndEmpty(final String sign) {
        assertThatThrownBy(() -> {
            Operator.execute(4, 2, sign);
        }).isInstanceOf()
            .hasMessage("부호 값이 누락되었습니다.");
    }

    @Test
    @DisplayName("Operator.execute 메소드에 넘겨지는 부호 값이 등록되지 않은 부호면 실패한다.")
    void execute_withWrongSign() {
        assertThatThrownBy(() -> {
            Operator.execute(4, 2, "x");
        }).isInstanceOf()
            .hasMessage("잘못된 부호입니다.");
    }
}
