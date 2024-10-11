import domain.Operator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class OperatorTest {
    @Test
    void 덧셈_테스트() {
        assertThat(Operator.PLUS.calculate(2, 3)).isEqualTo(5);
    }

    @Test
    void 뺄셈_테스트() {
        assertThat(Operator.MINUS.calculate(2, 3)).isEqualTo(-1);
    }

    @Test
    void 곱셈_테스트() {
        assertThat(Operator.MULTIPLY.calculate(2, 3)).isEqualTo(6);
    }

    @Test
    void 나눗셈_테스트() {
        assertThat(Operator.DIVIDE.calculate(6, 3)).isEqualTo(2);
    }

    @Test
    void 나누기_0으로_테스트() {
        assertThatThrownBy(() -> Operator.DIVIDE.calculate(1, 0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("0으로 나눌 수 없습니다.");
    }

    @Test
    void 유효한_기호로_인스턴스_가져오기() {
        assertThat(Operator.PLUS).isEqualTo(Operator.getInstance("+"));
        assertThat(Operator.MINUS).isEqualTo(Operator.getInstance("-"));
        assertThat(Operator.MULTIPLY).isEqualTo(Operator.getInstance("*"));
        assertThat(Operator.DIVIDE).isEqualTo(Operator.getInstance("/"));
    }

    @Test
    void 잘못된_기호로_인스턴스_가져오기() {
        assertThatThrownBy(() -> Operator.getInstance("^"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("잘못된 사칙연산 기호입니다 : ");
    }
}
