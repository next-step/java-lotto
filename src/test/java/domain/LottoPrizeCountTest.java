package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static domain.LottoPrize.*;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoPrizeCountTest {
    private LottoPrizeCount lottoPrizeCount;

    @BeforeEach
    void setUp() {
        lottoPrizeCount = new LottoPrizeCount();
    }

    @Test
    void incrementFirstTest(){
        Integer before = lottoPrizeCount.getPrizeCount(FIRST_PRIZE);
        lottoPrizeCount.incrementLottoPrize(FIRST_PRIZE);
        Integer after = lottoPrizeCount.getPrizeCount(FIRST_PRIZE);
        assertThat(before + 1).isEqualTo(after);
    }

    @Test
    void incrementSecondTest(){
        Integer before = lottoPrizeCount.getPrizeCount(SECOND_PRIZE);
        lottoPrizeCount.incrementLottoPrize(SECOND_PRIZE);
        Integer after = lottoPrizeCount.getPrizeCount(SECOND_PRIZE);
        assertThat(before + 1).isEqualTo(after);
    }

    @Test
    void incrementThirdTest(){
        Integer before = lottoPrizeCount.getPrizeCount(THIRD_PRIZE);
        lottoPrizeCount.incrementLottoPrize(THIRD_PRIZE);
        Integer after = lottoPrizeCount.getPrizeCount(THIRD_PRIZE);
        assertThat(before + 1).isEqualTo(after);
    }

    @Test
    void incrementFourthTest(){
        Integer before = lottoPrizeCount.getPrizeCount(FOURTH_PRIZE);
        lottoPrizeCount.incrementLottoPrize(FOURTH_PRIZE);
        Integer after = lottoPrizeCount.getPrizeCount(FOURTH_PRIZE);
        assertThat(before + 1).isEqualTo(after);
    }


}
