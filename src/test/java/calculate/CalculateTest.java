package calculate;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculateTest {

    Calculate cal;

    @BeforeEach
    void 계산기_호출() {
        cal = new Calculate();
    }

    @Test
    void 덧셈_테스트() {
        assertThat(cal.calculate("3 + 4")).isEqualTo(7);
    }

    @Test
    void 뺄셈_테스트() {
        assertThat(cal.calculate("5 - 2")).isEqualTo(3);
    }

    @Test
    void 곱셈_테스트() {
        assertThat(cal.calculate("2 * 3")).isEqualTo(6);
    }

    @Test
    void 나눗셈_테스트() {
        assertThat(cal.calculate("5 / 2")).isEqualTo(2);
    }

    @Test
    void 입력값_null_체크() {
        assertThatExceptionOfType(IllegalStateException.class)
                .isThrownBy(() -> cal.calculate(null));
    }

    @Test
    void 입력값_공백_체크() {
        assertThatExceptionOfType(IllegalStateException.class)
                .isThrownBy(() -> cal.calculate(""));
    }

    @Test
    void 계산_테스트() {
        assertThat(cal.calculate("2 + 3 * 4 / 2")).isEqualTo(10);
    }

    @DisplayName("나눗셈 실행시 두번째 인자 0 오류 확인")
    @Test
    void 계산_오류_테스트() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> cal.calculate("2 + 3 / 0"))
                .withMessageMatching("나누는 수는 0이 될 수 없습니다.");
    }

    @Test
    void 계산식_오류_테스트() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> cal.calculate("2 + 3 / 0/"))
                .withMessageContaining("계산할 문자열에 잘못된 정보가 존재합니다.");
    }

    @Test
    void 사칙연산자_오류_테스트() {
        assertThatThrownBy(() -> cal.calculate("2 % 6"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("허용된 사칙연산 기호가 아닙니다");
    }

}
