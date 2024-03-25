package lotto;

import lotto.prize.LottoPrize;
import org.assertj.core.api.Assertions;
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
    @DisplayName("count값으로 문자열을 반환한다.")
    void getTextFormattedByCount(){
        String text = LottoPrize.MATCH_3.formatPrizeText(5);
        Assertions.assertThat(text).isEqualTo("3개 일치 (5000원)- 5개/n");
    }

    @Test
    @DisplayName("count의 값을 가지고있는 enum값을 반환한다.")
    void findLottoPrizeByCount() {
        assertThat(LottoPrize.from(3)).isEqualTo(LottoPrize.MATCH_3);
        assertThat(LottoPrize.from(5)).isEqualTo(LottoPrize.MATCH_5);
    }

    @Test
    @DisplayName("count의 값이 없을경우 LottoPrize.None을 반환한다.")
    void returnNonePrize() {
        assertThat(LottoPrize.from(0)).isEqualTo(LottoPrize.NONE);
        assertThat(LottoPrize.from(1)).isEqualTo(LottoPrize.NONE);
        assertThat(LottoPrize.from(10)).isEqualTo(LottoPrize.NONE);
    }
}