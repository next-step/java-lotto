package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LotteryStaticsTest {

    @Test
    @DisplayName("당첨 횟수 테스트")
    void countLotto() {
        //given
        int buyCount = 4000;
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(Arrays.asList(1, 8, 23, 41, 42, 43))); //3개일치
        lottos.add(new Lotto(Arrays.asList(3, 5, 11, 16, 32, 38))); //1개일치
        lottos.add(new Lotto(Arrays.asList(7, 11, 16, 35, 36, 44))); //1개일치
        lottos.add(new Lotto(Arrays.asList(1, 8, 11, 31, 41, 42))); //5개일치

        Lotto winNum = new Lotto(Arrays.asList(1, 8, 11, 31, 41, 44));

        //when
        LotteryStatics lotteryStatics = new LotteryStatics(buyCount, lottos, winNum.getLotto());

        //then
        assertThat(lotteryStatics.getLotteryStatics().get(Rank.FOURTH)).isEqualTo(1);
        assertThat(lotteryStatics.getLotteryStatics().get(Rank.THRID)).isNull();
        assertThat(lotteryStatics.getLotteryStatics().get(Rank.SECOND)).isEqualTo(1);
        assertThat(lotteryStatics.getLotteryStatics().get(Rank.FIRST)).isNull();

    }

    @Test
    @DisplayName("당첨 금액 합 테스트")
    void sumLotto() {
        //given
        int buyCount = 4000;
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(Arrays.asList(1, 8, 23, 41, 42, 43))); //3개일치
        lottos.add(new Lotto(Arrays.asList(3, 5, 11, 16, 32, 38))); //1개일치
        lottos.add(new Lotto(Arrays.asList(7, 11, 16, 35, 36, 44))); //1개일치
        lottos.add(new Lotto(Arrays.asList(1, 8, 11, 31, 41, 42))); //5개일치

        Lotto winNum = new Lotto(Arrays.asList(1, 8, 11, 31, 41, 44));

        //when
        LotteryStatics lotteryStatics = new LotteryStatics(buyCount, lottos, winNum.getLotto());
        int priceSum = lotteryStatics.getTotalPrice();

        //then
        assertEquals(5000 + 1500000, priceSum);

    }


    @Test
    @DisplayName("수익률 테스트")
    void grossTest() {
        //given
        int buyCount = 4000;
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(Arrays.asList(1, 8, 23, 41, 42, 43))); //3개일치
        lottos.add(new Lotto(Arrays.asList(3, 5, 11, 16, 32, 38))); //1개일치
        lottos.add(new Lotto(Arrays.asList(7, 11, 16, 35, 36, 44))); //1개일치
        lottos.add(new Lotto(Arrays.asList(1, 2, 3, 31, 41, 42))); //3개일치

        Lotto winNum = new Lotto(Arrays.asList(1, 8, 11, 31, 41, 44));

        //when
        LotteryStatics lotteryStatics = new LotteryStatics(buyCount, lottos, winNum.getLotto());

        //then
        double expected = 2.5;

        assertEquals(expected, lotteryStatics.getGross());
    }
}
