package lotto.model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Java6Assertions.assertThat;

public class StatisticTest {

    @Test
    void test_get_count_of_winning_numbers_from_lotto() {
        LottoGenerator lottoGenerator = new LottoGenerator(new MockNumberGenerator());
        List<Lotto> lottos = lottoGenerator.generate(2000);

        List<Integer> winningNumbers = Arrays.asList(1,2,3,4,5,6);
        List<Integer> count_of_matching_numbers = lottos.stream().mapToInt(lotto -> lotto.hasHowMany(winningNumbers)).boxed().collect(toList());

        assertThat(count_of_matching_numbers).containsExactly(6, 6);
    }

    @Test
    void test_get_Prize() {
        int count_of_matching_numbers = 6;
        Prize prize = Prize.valueOf(count_of_matching_numbers);

        assertThat(prize.name()).isEqualTo("FIRST");
        assertThat(prize.getPrizeMoney()).isEqualTo(2000000000);
    }

    @Test
    void test_total_prize_money() {
        List<Integer> count_of_matching_numbers = Arrays.asList(1, 3, 6);

        List<Prize> prizes = count_of_matching_numbers.stream()
                .map(Prize::valueOf)
                .collect(toList());

        int total = prizes.stream().map(Prize::getPrizeMoney).reduce(0, Integer::sum);

        assertThat(total).isEqualTo(2000005000);
    }
}
