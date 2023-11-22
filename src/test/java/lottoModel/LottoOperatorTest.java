package lottoModel;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoOperatorTest {

    @Test
    @DisplayName("더하기: ADD")
    void add_더하기() {
        LottoOperator lottoOperator = new LottoOperator();
        double reuslt = lottoOperator.calculate(1000, 5000, LottoOperator.Operator.ADD);
        assertThat(reuslt).isEqualTo(6000);
    }

    @Test
    @DisplayName("빼기: MINUS")
    void minus_빼기() {
        LottoOperator lottoOperator = new LottoOperator();
        double reuslt = lottoOperator.calculate(5000, 1000, LottoOperator.Operator.MINUS);
        assertThat(reuslt).isEqualTo(4000);
    }

    @Test
    @DisplayName("곱하기: multiply")
    void multiply_곱하기() {
        LottoOperator lottoOperator = new LottoOperator();
        double reuslt = lottoOperator.calculate(2, 2, LottoOperator.Operator.MULTIPLY);
        assertThat(reuslt).isEqualTo(4);
    }

    @Test
    @DisplayName("정수로 떨어지는 나누기: divide")
    void divide_정수() {
        LottoOperator lottoOperator = new LottoOperator();
        double reuslt = lottoOperator.calculate(2, 2, LottoOperator.Operator.DIVIDE);
        assertThat(reuslt).isEqualTo(1);
    }
}
