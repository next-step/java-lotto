package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.assertj.core.api.Assertions.*;

public class LottoRankCounterTest {
    private LottoRankCounter lottoRankCounter;

    @BeforeEach
    public void setUp() {
        this.lottoRankCounter = new LottoRankCounter();
    }

    @DisplayName("카운트를 더한 만큼, 카운트가 리턴되어야 합니다.")
    @Test
    public void testCount() {
        Random random = new Random();

        Arrays.stream(LottoRank.values())
              .forEach(rank -> assertThatCountOfRank(rank, random.nextInt(10)));
    }

    private void assertThatCountOfRank(LottoRank rank, int times) {
        int loopCount = times;
        while (loopCount -- > 0) {
            this.lottoRankCounter.addCount(rank);
        }

        int count = this.lottoRankCounter.getCount(rank);
        assertThat(count).isEqualTo(times);
    }
}
