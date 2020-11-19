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
        lottoPrizeCount.incrementLottoPrize(LottoPrize.FIRST_PRIZE);
        Long after = lottoPrizeCount.getFirstPrizeCount();
        assertThat(before + 1).isEqualTo(after);
    }

    @Test
    void incrementSecondTest(){
        Long before = lottoPrizeCount.getSecondPrizeCount();
        lottoPrizeCount.incrementLottoPrize(LottoPrize.SECOND_PRIZE);
        Long after = lottoPrizeCount.getSecondPrizeCount();
        assertThat(before + 1).isEqualTo(after);
    }

    @Test
    void incrementThirdTest(){
        Long before = lottoPrizeCount.getThirdPrizeCount();
        lottoPrizeCount.incrementLottoPrize(LottoPrize.THIRD_PRIZE);
        Long after = lottoPrizeCount.getThirdPrizeCount();
        assertThat(before + 1).isEqualTo(after);
    }

    @Test
    void incrementFourthTest(){
        Long before = lottoPrizeCount.getFourthPrizeCount();
        lottoPrizeCount.incrementLottoPrize(LottoPrize.FOURTH_PRIZE);
        Long after = lottoPrizeCount.getFourthPrizeCount();
        assertThat(before + 1).isEqualTo(after);
    }


}
