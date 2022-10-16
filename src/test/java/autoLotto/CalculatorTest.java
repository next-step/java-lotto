package autoLotto;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class CalculatorTest {

    @Test
    void test() {
        Lottos lottos = new Lottos();
        lottos.addLotto(new Lotto());

        Calculator calculator = new Calculator();

        List<Integer> integerList = new ArrayList<>();
        IntStream.range(1, 46).forEach(i -> integerList.add(i));

        System.out.println(lottos.getLotto(0));

        calculator.matchNumber(lottos, new Numbers(integerList), 1000);
    }
}
