package autoLotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CalculatorTest {
    private Calculator calculator;
    private Lottos lottos;
    private GameResult result;
    @BeforeEach
    void init() {
        calculator = new Calculator();
        result = new GameResult();

        lottos = new Lottos(getLottos());
    }

    private List<Lotto> getLottos() {
        Lotto lotto = new Lotto(new Integer[]{3, 5, 7, 11, 45, 23});
        List<Lotto> lottoList = new ArrayList<>();
        lottoList.add(lotto);
        return lottoList;
    }

    @Test
    void 등수_1등() {
        List<Integer> integerList = Arrays.asList(3, 5, 7, 11, 45, 23);
        calculator.calculate(lottos, new WinningNumbers(integerList, 1), result);

        Assertions.assertThat(result.getResult()).isEqualTo(2000000.0);
    }

    @Test
    void 등수_2등() {
        List<Integer> integerList = Arrays.asList(3, 5, 7, 11, 45, 24);
        calculator.calculate(lottos, new WinningNumbers(integerList, 23), result);

        Assertions.assertThat(result.getResult()).isEqualTo(30000.0);
    }

    @Test
    void 등수_3등() {
        List<Integer> integerList = Arrays.asList(3, 5, 7, 11, 45, 24);
        calculator.calculate(lottos, new WinningNumbers(integerList, 25), result);

        Assertions.assertThat(result.getResult()).isEqualTo(1500.0);
    }

    @Test
    void 등수_4등() {
        List<Integer> integerList = Arrays.asList(3, 5, 7, 11, 44, 24);
        calculator.calculate(lottos, new WinningNumbers(integerList, 25), result);

        Assertions.assertThat(result.getResult()).isEqualTo(50.0);
    }

    @Test
    void 등수_5등() {
        List<Integer> integerList = Arrays.asList(3, 5, 7, 10, 44, 24);
        calculator.calculate(lottos, new WinningNumbers(integerList, 25), result);

        Assertions.assertThat(result.getResult()).isEqualTo(5.0);
    }

    @Test
    void 등수_MISS() {
        List<Integer> integerList = Arrays.asList(3, 5, 6, 10, 44, 24);
        calculator.calculate(lottos, new WinningNumbers(integerList, 25), result);

        Assertions.assertThat(result.getResult()).isEqualTo(0.0);
    }

}
