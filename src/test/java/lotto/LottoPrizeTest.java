package lotto;

import lotto.prize.LottoPrize;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class LottoPrizeTest {

    @Test
    @DisplayName("LottoPrize의 상금과 count의 곱을 반환한다.")
    void multipleLottoPrizeAndCount(){
        int totalPrice = LottoPrize.MATCH_4.getTotalPrice(4);
        assertThat(totalPrice).isEqualTo(200000);
    }

    @Test
    @DisplayName("count의 값을 가지고있는 enum값을 반환한다.")
    void findLottoPrizeByCount() {
        assertThat(LottoPrize.from(3,false)).isEqualTo(LottoPrize.MATCH_3);
        assertThat(LottoPrize.from(5,false)).isEqualTo(LottoPrize.MATCH_5);
        assertThat(LottoPrize.from(5,true)).isEqualTo(LottoPrize.MATCH_5_BONUS);
    }

    @Test
    @DisplayName("count의 값이 없을경우 LottoPrize.None을 반환한다.")
    void returnNonePrize() {
        assertThat(LottoPrize.from(0,false)).isEqualTo(LottoPrize.NONE);
        assertThat(LottoPrize.from(1,true)).isEqualTo(LottoPrize.NONE);
        assertThat(LottoPrize.from(10,true)).isEqualTo(LottoPrize.NONE);
    }
}