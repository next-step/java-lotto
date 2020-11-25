package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {
    private Lottos lottos;

    @BeforeEach
    void setUp() throws Exception {
        List<String> lottoNumbers = new ArrayList<>();
        lottoNumbers.add("1,2,3,4,5,6");

        lottos = Lottos.of(lottoNumbers);
    }

    @Test
    void calculateTest() throws Exception {
        LottoResult lottoResult = lottos.calculate(Lotto.of(Arrays.asList(1,2,3,4,5,6)),7);
        LottoPrizeCount lottoPrizeCount = lottoResult.getLottoPrizeCount();

        assertThat(lottoPrizeCount.getPrizeCount(LottoPrize.FIRST_PRIZE).equals(1L));
        assertThat(lottoResult.calculateProfitRates()).isEqualTo(2_000_000);
    }
}
