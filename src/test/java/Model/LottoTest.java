package Model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoTest {

    @Test
    @DisplayName("당첨 횟수 테스트")
    void countLotto() {
        //given
        int count = 4;
        ArrayList<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(new ArrayList<>(Arrays.asList(8, 21, 23, 41, 42, 43)))); //1개일치
        lottos.add(new Lotto(new ArrayList<>(Arrays.asList(3, 5, 11, 16, 32, 38)))); //1개일치
        lottos.add(new Lotto(new ArrayList<>(Arrays.asList(7, 11, 16, 35, 36, 44)))); //1개일치
        lottos.add(new Lotto(new ArrayList<>(Arrays.asList(1, 8, 11, 31, 41, 42)))); //5개일치

        WinNum winNum = new WinNum(new ArrayList<>(Arrays.asList(1, 8, 11, 31, 41, 44)));

        /*winRule
         *3개 일치 (5000원)
         *4개 일치 (50000원)
         *5개 일치 (1500000원)
         *6개 일치 (2000000000원)
         */
        WinRule winRule = new WinRule();

        //when
        WinCount winCount = new WinCount(winRule, lottos, winNum);

        //then
        assertEquals(null, winCount.getWinCount().get(3)); //3개일치
        assertEquals(null, winCount.getWinCount().get(4)); //4개일치
        assertEquals(1, winCount.getWinCount().get(5)); //5개일치
        assertEquals(null, winCount.getWinCount().get(6)); //6개일치

    }

    @Test
    @DisplayName("당첨 금액 합 테스트")
    void sumLotto() {
        //given
        int count = 4;
        ArrayList<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(new ArrayList<>(Arrays.asList(8, 21, 23, 41, 42, 43)))); //1개일치
        lottos.add(new Lotto(new ArrayList<>(Arrays.asList(3, 5, 11, 16, 32, 38)))); //1개일치
        lottos.add(new Lotto(new ArrayList<>(Arrays.asList(7, 11, 16, 35, 36, 44)))); //1개일치
        lottos.add(new Lotto(new ArrayList<>(Arrays.asList(1, 8, 11, 31, 41, 42)))); //5개일치

        WinNum winNum = new WinNum(new ArrayList<>(Arrays.asList(1, 8, 11, 31, 41, 44)));

        /*winRule
         *3개 일치 (5000원)
         *4개 일치 (50000원)
         *5개 일치 (1500000원)
         *6개 일치 (2000000000원)
         */
        WinRule winRule = new WinRule();

        WinCount winCount = new WinCount(winRule, lottos, winNum);

        LotteryStatics lotteryStatics = new LotteryStatics(winRule, winCount);
        //when

        int priceSum = lotteryStatics.getSumPirze();

        //then
        assertEquals(1500000, priceSum);

    }
}
