package domain;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;

import domain.type.LottoRankResult;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class LottoProfitTest {
    @Test
    void getProfitRateTDD() {
        BigDecimal bd1 = new BigDecimal(100);
        BigDecimal bd2 = new BigDecimal(2000);
        BigDecimal result = bd1.divide(bd2);

        System.out.println(result.setScale(2));
    }

    @Test
    void getProfitAmountSumTest() {
        Integer[] intArray = new Integer[] { 1, 2, 3 };
        List<Integer> list = List.of(intArray);

        assertThat(LottoProfit.getProfitAmountSum(list), is(new BigDecimal(6)));
    }

    @Test
    void getProfitSumTest() {
        List<LottoRankResult> list = List.of(LottoRankResult.FIRST, LottoRankResult.FIFTH);
        list.forEach(it -> System.out.println(it.getAmount().getReward()));
        System.out.println(LottoProfit.getProfitSum(list));

        System.out.println(list);

        assertThat(LottoProfit.getProfitSum(list), is(new BigDecimal(2000005000)));
    }
}
