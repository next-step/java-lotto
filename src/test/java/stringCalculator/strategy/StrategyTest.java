package stringCalculator.strategy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class StrategyTest {

    @DisplayName("숫자 2개를 전달하면 더하기를 한다.")
    @ParameterizedTest
    @CsvSource(value = {"1:3", "2:5", "3:3", "4:2", "5:11"}, delimiter = ':')
    public void PlusStrategyTest(int prevNum, int nextNum) {

        PlusStrategy plusStrategy = new PlusStrategy();

        assertThat(plusStrategy.calculator(prevNum, nextNum)).isEqualTo(prevNum + nextNum);
    }

    @DisplayName("숫자 2개를 전달하면 빼기를 한다.")
    @ParameterizedTest
    @CsvSource(value = {"1:3", "2:5", "3:3", "4:2", "5:11"}, delimiter = ':')
    public void MinusStrategyTest(int prevNum, int nextNum) {

        MinusStrategy strategy = new MinusStrategy();

        assertThat(strategy.calculator(prevNum, nextNum)).isEqualTo(prevNum - nextNum);
    }

    @DisplayName("숫자 2개를 전달하면 곱하기를 한다.")
    @ParameterizedTest
    @CsvSource(value = {"1:3", "2:5", "3:3", "4:2", "5:11"}, delimiter = ':')
    public void MultiplyStrategyTest(int prevNum, int nextNum) {

        MultiplyStrategy strategy = new MultiplyStrategy();

        assertThat(strategy.calculator(prevNum, nextNum)).isEqualTo(prevNum * nextNum);
    }

    @DisplayName("숫자 2개를 전달하면 나누기를 한다.")
    @ParameterizedTest
    @CsvSource(value = {"1:3", "2:5", "3:3", "4:2", "5:11"}, delimiter = ':')
    public void DivideStrategyTest(int prevNum, int nextNum) {

        DivideStrategy strategy = new DivideStrategy();

        assertThat(strategy.calculator(prevNum, nextNum)).isEqualTo(prevNum / nextNum);
    }
}
