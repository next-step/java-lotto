package lotto.model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class StatisticTest {

    @Test
    void test_get_count_of_matching_numbers_from_lottos() {
        LottoGenerator lottoGenerator = new LottoGenerator(new MockNumberGenerator());
        Lottos lottos = lottoGenerator.generate(2000);

        List<Integer> winningNumbers = Arrays.asList(1,2,3,4,5,6);
        List<Integer> count_of_matching_numbers = lottos.getCountOfMatchingNumbers(winningNumbers);

        assertThat(count_of_matching_numbers).containsExactly(6, 6);
    }

    @Test
    void test_get_Prize() {
        int count_of_matching_numbers = 6;
        Prize prize = Prize.valueOf(count_of_matching_numbers);

        assertThat(prize.name()).isEqualTo("FIRST");
        assertThat(prize.getPrizeMoney()).isEqualTo(2000000000);
    }
}
