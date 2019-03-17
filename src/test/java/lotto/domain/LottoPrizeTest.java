package lotto.domain;


import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoPrizeTest {
    @Test
    public void enum_name_테스트() {
        LottoPrize lottoPrize = LottoPrize.getEnumNameByIntValue(6);
        assertThat(lottoPrize).isEqualTo(LottoPrize.FIRST);
    }

    @Test(expected = IllegalArgumentException.class)
    public void enum_name_에러테스트() {
        LottoPrize.getEnumNameByIntValue(-1);
    }
}