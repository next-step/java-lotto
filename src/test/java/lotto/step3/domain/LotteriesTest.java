package lotto.step3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LotteriesTest {

    @Test
    @DisplayName("orderCount를 받는 생성자")
    void createLotteries() {
        Lotteries lotteries = new Lotteries(14);
        assertThat(lotteries.getLotteries()).size().isEqualTo(14);
    }

    @Test
    @DisplayName("orderCount, List<List<Integer>> 를 받는 생성자")
    void createLotteries1() {
        List<List<Integer>> input = Arrays.asList(Arrays.asList(1, 2, 3, 4, 5, 6),
                Arrays.asList(1, 2, 3, 4, 5, 7),
                Arrays.asList(1, 2, 3, 4, 5, 7));
        Lotteries lotteries = new Lotteries(input, 3);
        assertThat(lotteries.getLotteries()).size().isEqualTo(6);
    }

}