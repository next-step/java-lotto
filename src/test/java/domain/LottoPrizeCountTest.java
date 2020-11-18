package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoPrizeCountTest {
    private LottoPrizeCount lottoPrizeCount;

    @BeforeEach
    void setUp() {
        lottoPrizeCount = new LottoPrizeCount();
    }

    @Test
    void incrementFirstTest(){
        Long before = lottoPrizeCount.getFirstPrizeCount();
        lottoPrizeCount.incrementFirst();
        Long after = lottoPrizeCount.getFirstPrizeCount();
        assertThat(before + 1).isEqualTo(after);
    }

    @Test
    void incrementSecondTest(){
        Long before = lottoPrizeCount.getSecondPrizeCount();
        lottoPrizeCount.incrementSecond();
        Long after = lottoPrizeCount.getSecondPrizeCount();
        assertThat(before + 1).isEqualTo(after);
    }

    @Test
    void incrementThirdTest(){
        Long before = lottoPrizeCount.getThirdPrizeCount();
        lottoPrizeCount.incrementThird();
        Long after = lottoPrizeCount.getThirdPrizeCount();
        assertThat(before + 1).isEqualTo(after);
    }

    @Test
    void incrementFistTest(){
        Long before = lottoPrizeCount.getFourthPrizeCount();
        lottoPrizeCount.incrementFourth();
        Long after = lottoPrizeCount.getFourthPrizeCount();
        assertThat(before + 1).isEqualTo(after);
    }


}
