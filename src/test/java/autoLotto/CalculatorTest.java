package autoLotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class CalculatorTest {
    private Calculator calculator;
    private Lottos lottos;
    @BeforeEach
    void init() {
        calculator = new Calculator();

        lottos = new Lottos();
        lottos.addLotto(new Lotto(new Integer[]{3, 5, 7, 11, 45, 23}));
    }

    @Test
    void 등수_1등() {
        List<Integer> integerList = Arrays.asList(3, 5, 7, 11, 45, 23);
        double result = calculator.calculate(lottos, new WinningNumbers(integerList, 1), 1000);

        Assertions.assertThat(result).isEqualTo(2000000.0);
    }

    @Test
    void 등수_2등() {
        List<Integer> integerList = Arrays.asList(3, 5, 7, 11, 45, 24);
        double result = calculator.calculate(lottos, new WinningNumbers(integerList, 23), 1000);

        Assertions.assertThat(result).isEqualTo(30000.0);
    }

    @Test
    void 등수_3등() {
        List<Integer> integerList = Arrays.asList(3, 5, 7, 11, 45, 24);
        double result = calculator.calculate(lottos, new WinningNumbers(integerList, 25), 1000);

        Assertions.assertThat(result).isEqualTo(1500.0);
    }

    @Test
    void 등수_4등() {
        List<Integer> integerList = Arrays.asList(3, 5, 7, 11, 44, 24);
        double result = calculator.calculate(lottos, new WinningNumbers(integerList, 25), 1000);

        Assertions.assertThat(result).isEqualTo(50.0);
    }

    @Test
    void 등수_5등() {
        List<Integer> integerList = Arrays.asList(3, 5, 7, 10, 44, 24);
        double result = calculator.calculate(lottos, new WinningNumbers(integerList, 25), 1000);

        Assertions.assertThat(result).isEqualTo(5.0);
    }

    @Test
    void 등수_MISS() {
        List<Integer> integerList = Arrays.asList(3, 5, 6, 10, 44, 24);
        double result = calculator.calculate(lottos, new WinningNumbers(integerList, 25), 1000);

        Assertions.assertThat(result).isEqualTo(0.0);
    }

}
