package Lotto.utils;

import org.junit.jupiter.api.RepeatedTest;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomTest {
    private static final Integer LOTTO_SIZE = 6;

    @RepeatedTest(10)
    public void randomGenerateTest() {
        List<Integer> numbers1 = Random.generateRandomLottoNumbers();
        List<Integer> numbers2 = Random.generateRandomLottoNumbers();

        numbers1.retainAll(numbers2);
        assertThat(numbers1.size()).isLessThan(LOTTO_SIZE);
    }
}
