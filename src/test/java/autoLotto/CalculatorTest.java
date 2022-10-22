package autoLotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class CalculatorTest {

    @Test
    void 결과_계산() {
        Calculator calculator = new Calculator();

        Lottos lottos = new Lottos();
        lottos.addLotto(new Lotto(new Integer[]{3, 5, 7, 11, 45, 23}));

        List<Integer> integerList = Arrays.asList(new Integer[]{3, 5, 7, 12, 43, 22});
        double result = calculator.calculate(lottos, new WinningNumbers(integerList, 1), 1000);

        Assertions.assertThat(result).isEqualTo(5.0);
    }
}
