package com.nextstep.lotto.view;

import com.nextstep.lotto.domain.LottoPrize;
import com.nextstep.lotto.domain.Money;
import com.nextstep.lotto.domain.Rank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class StatisticsOutputViewTest {
    private LottoPrize lottoPrize;

    @BeforeEach
    void setup() {
        lottoPrize = new LottoPrize(Arrays.asList(Rank.FIRST, Rank.SECOND, Rank.FOURTH));
    }

    @DisplayName("당첨 결과를 보여줄 수 있다.")
    @Test
    void parseLottoPrizeTest() {
        String expected = "3개 일치 (5000원)- 1개\n" +
                "4개 일치 (50000원)- 0개\n" +
                "5개 일치 (1500000원)- 1개\n" +
                "6개 일치 (2000000000원)- 1개\n";

        assertThat(StatisticsOutputView.parseLottoPrize(lottoPrize)).isEqualTo(expected);
    }

    @DisplayName("수익률을 보여줄 수 있다.")
    @Test
    void parseProfitTest() {
        Money money = new Money(11000L);
        String expected = "총 수익률은 181955.0입니다.(기준이 1이기 때문에 결과적으로 이득이라는 의미임)";

        assertThat(StatisticsOutputView.parseProfit(money, lottoPrize)).isEqualTo(expected);
    }
}
