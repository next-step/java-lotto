package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {
    private Lottos lottos;

    @BeforeEach
    void setUp() {
        List<List<Integer>> lottoNumbers = new ArrayList<>();
        lottoNumbers.add(Arrays.stream(new int[]{1, 2, 3, 4, 5, 6}).boxed().collect(Collectors.toList()));
        lottos = new Lottos(lottoNumbers);
    }

    @Test
    void makeStatisticsTest() throws Exception {
        LottoResult lottoResult = lottos.makeStatistics(Arrays.stream(new int[]{1, 2, 3, 4, 5, 6})
                                                            .boxed()
                                                            .collect(Collectors.toList()));
        LottoPrizeCount lottoPrizeCount = lottoResult.getLottoPrizeCount();

        assertThat(lottoPrizeCount.getFirstPrizeCount().equals(1L));
        assertThat(lottoResult.getProfitRates()).isEqualTo(2_000_000L);
    }
}
