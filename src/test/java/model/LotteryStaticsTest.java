package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class LotteryStaticsTest {

    @Test
    @DisplayName("당첨 횟수 테스트")
    void countLotto() {
        //given
        int count = 4;
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(Arrays.asList(1, 8, 23, 41, 42, 43))); //3개일치
        lottos.add(new Lotto(Arrays.asList(3, 5, 11, 16, 32, 38))); //1개일치
        lottos.add(new Lotto(Arrays.asList(7, 11, 16, 35, 36, 44))); //1개일치
        lottos.add(new Lotto(Arrays.asList(1, 8, 11, 31, 41, 42))); //5개일치

        Lotto winNum = new Lotto(Arrays.asList(1, 8, 11, 31, 41, 44));
        /*winRule
         *3개 일치 (5000원)
         *4개 일치 (50000원)
         *5개 일치 (1500000원)
         *6개 일치 (2000000000원)
         */
        WinRule winRule = new WinRule();

        //when
        LotteryStatics lotteryStatics = new LotteryStatics(winRule, lottos, winNum.getLotto());

        //then
        assertEquals(1, lotteryStatics.getLotteryStatics().get(Rank.FOURTH));
        assertNull(lotteryStatics.getLotteryStatics().get(Rank.THRID));
        assertEquals(1, lotteryStatics.getLotteryStatics().get(Rank.SECOND));
        assertNull(lotteryStatics.getLotteryStatics().get(Rank.FIRST));

    }

    @Test
    @DisplayName("당첨 금액 합 테스트")
    void sumLotto() {
        //given
        int count = 4;
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(Arrays.asList(1, 8, 23, 41, 42, 43))); //3개일치
        lottos.add(new Lotto(Arrays.asList(3, 5, 11, 16, 32, 38))); //1개일치
        lottos.add(new Lotto(Arrays.asList(7, 11, 16, 35, 36, 44))); //1개일치
        lottos.add(new Lotto(Arrays.asList(1, 8, 11, 31, 41, 42))); //5개일치

        Lotto winNum = new Lotto(Arrays.asList(1, 8, 11, 31, 41, 44));

        /*winRule
         *3개 일치 (5000원)
         *4개 일치 (50000원)
         *5개 일치 (1500000원)
         *6개 일치 (2000000000원)
         */
        WinRule winRule = new WinRule();

        //when
        LotteryStatics lotteryStatics = new LotteryStatics(winRule, lottos, winNum.getLotto());
        int priceSum = lotteryStatics.getTotalPrice();

        //then
        assertEquals(5000 + 1500000, priceSum);

    }
}
