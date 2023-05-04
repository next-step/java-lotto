package stringCalculator.strategy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import stringCalculator.domain.Operand;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StrategyTest {

    @DisplayName("숫자 2개를 전달하면 더하기를 한다.")
    @ParameterizedTest
    @CsvSource(value = {"1:3", "2:5", "3:3", "4:2", "5:11"}, delimiter = ':')
    public void PlusStrategyTest(int prevNum, int nextNum) {

        PlusStrategy plusStrategy = new PlusStrategy();

        assertThat(plusStrategy.applyAsInt(prevNum, nextNum)).isEqualTo(prevNum + nextNum);
    }

    @DisplayName("숫자 2개를 전달하면 빼기를 한다.")
    @ParameterizedTest
    @CsvSource(value = {"1:3", "2:5", "3:3", "4:2", "5:11"}, delimiter = ':')
    public void MinusStrategyTest(int prevNum, int nextNum) {

        MinusStrategy strategy = new MinusStrategy();

        assertThat(strategy.applyAsInt(prevNum, nextNum)).isEqualTo(prevNum - nextNum);
    }

    @DisplayName("숫자 2개를 전달하면 곱하기를 한다.")
    @ParameterizedTest
    @CsvSource(value = {"1:3", "2:5", "3:3", "4:2", "5:11"}, delimiter = ':')
    public void MultiplyStrategyTest(int prevNum, int nextNum) {

        MultiplyStrategy strategy = new MultiplyStrategy();

        assertThat(strategy.applyAsInt(prevNum, nextNum)).isEqualTo(prevNum * nextNum);
    }

    @DisplayName("숫자 2개를 전달하면 나누기를 한다.")
    @ParameterizedTest
    @CsvSource(value = {"1:3", "2:5", "3:3", "4:2", "5:11"}, delimiter = ':')
    public void DivideStrategyTest(int prevNum, int nextNum) {

        DivideStrategy strategy = new DivideStrategy();

        assertThat(strategy.applyAsInt(prevNum, nextNum)).isEqualTo(prevNum / nextNum);
    }

    @DisplayName("나누는 숫자가 0인 경우 에러를 전달한다.")
    @ParameterizedTest
    @CsvSource(value = {"1:0", "2:0"}, delimiter = ':')
    public void DivideStrategyTest_0으로_나눌시_에러전달(int prevNum, int nextNum) {

        DivideStrategy strategy = new DivideStrategy();

        assertThatThrownBy(() -> strategy.applyAsInt(prevNum, nextNum))
                .isInstanceOf(ArithmeticException.class);
    }
}
