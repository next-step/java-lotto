package lotto;


import lotto.domain.LottoPrize;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoPrizeTest {
    @Test
    public void enum_name_1등() {
        LottoPrize lottoPrize = LottoPrize.getEnumNameByIntValue(6, false);
        assertThat(lottoPrize).isEqualTo(LottoPrize.FIRST);
    }

    @Test
    public void enum_name_2등() {
        LottoPrize lottoPrize = LottoPrize.getEnumNameByIntValue(5, true);
        assertThat(lottoPrize).isEqualTo(LottoPrize.SECOND);
    }

    @Test
    public void enum_name_3등() {
        LottoPrize lottoPrize = LottoPrize.getEnumNameByIntValue(5, false);
        assertThat(lottoPrize).isEqualTo(LottoPrize.THIRD);
    }

    @Test(expected = IllegalArgumentException.class)
    public void enum_name_에러테스트() {
        LottoPrize.getEnumNameByIntValue(-1, false);
    }
}