package lotto.utils;

import org.junit.jupiter.api.RepeatedTest;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomLottoNumbersGeneratorTest {
    private static final Integer LOTTO_SIZE = 6;

    @RepeatedTest(10)
    public void randomGenerateTest() {
        List<Integer> numbers1 = RandomLottoNumbersGenerator.generate();
        List<Integer> numbers2 = RandomLottoNumbersGenerator.generate();

        numbers1.retainAll(numbers2);
        assertThat(numbers1.size()).isLessThan(LOTTO_SIZE);
    }
}
