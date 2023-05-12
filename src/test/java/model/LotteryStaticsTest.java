package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

class LotteryStaticsTest {

    @Test
    @DisplayName("당첨 횟수 테스트")
    void countLotto() {
        //given
        int buyCount = 4000;
        int bonus = 7;
        List<Lotto> lottoList = new ArrayList<>();
        lottoList.add(new Lotto(Arrays.asList(1, 8, 23, 41, 42, 43))); //3개일치
        lottoList.add(new Lotto(Arrays.asList(3, 5, 11, 16, 32, 38))); //1개일치
        lottoList.add(new Lotto(Arrays.asList(7, 11, 16, 35, 36, 44))); //1개일치
        lottoList.add(new Lotto(Arrays.asList(1, 8, 11, 31, 41, 7))); //5개일치, 보너스볼 일치

        Lottos lottos = new Lottos(lottoList);

        WinNum winNum = new WinNum(Arrays.asList(1, 8, 11, 31, 41, 44), bonus);

        //when
        LotteryStatics lotteryStatics = new LotteryStatics(buyCount, lottos, winNum);

        //then
        assertSoftly(softly -> {
            assertThat(lotteryStatics.getLotteryStatics().get(Rank.MISS)).isEqualTo(2);
            assertThat(lotteryStatics.getLotteryStatics().get(Rank.FIFTH)).isEqualTo(1);
            assertThat(lotteryStatics.getLotteryStatics().get(Rank.FOURTH)).isNull();
            assertThat(lotteryStatics.getLotteryStatics().get(Rank.THIRD)).isNull();
            assertThat(lotteryStatics.getLotteryStatics().get(Rank.SECOND)).isEqualTo(1);
            assertThat(lotteryStatics.getLotteryStatics().get(Rank.FIRST)).isNull();
        });

    }

    @Test
    @DisplayName("당첨 금액 합 테스트")
    void sumLotto() {
        //given
        int buyCount = 4000;
        int bonus = 7;

        List<Lotto> lottoList = new ArrayList<>();
        lottoList.add(new Lotto(Arrays.asList(1, 8, 23, 41, 42, 43))); //3개일치
        lottoList.add(new Lotto(Arrays.asList(3, 5, 11, 16, 32, 38))); //1개일치
        lottoList.add(new Lotto(Arrays.asList(7, 11, 16, 35, 36, 44))); //1개일치
        lottoList.add(new Lotto(Arrays.asList(1, 8, 11, 31, 41, 7))); //5개일치, 보너스볼 일치

        Lottos lottos = new Lottos(lottoList);

        WinNum winNum = new WinNum(Arrays.asList(1, 8, 11, 31, 41, 44), bonus);

        //when
        LotteryStatics lotteryStatics = new LotteryStatics(buyCount, lottos, winNum);
        int priceSum = lotteryStatics.getTotalPrice();

        //then
        assertThat(priceSum).isEqualTo(5_000 + 30_000_000);

    }


    @Test
    @DisplayName("수익률 테스트")
    void grossTest() {
        //given
        int buyCount = 4000;
        int bonus = 7;

        List<Lotto> lottoList = new ArrayList<>();
        lottoList.add(new Lotto(Arrays.asList(1, 8, 23, 41, 42, 43))); //3개일치
        lottoList.add(new Lotto(Arrays.asList(3, 5, 11, 16, 32, 38))); //1개일치
        lottoList.add(new Lotto(Arrays.asList(7, 11, 16, 35, 36, 44))); //1개일치
        lottoList.add(new Lotto(Arrays.asList(1, 8, 11, 31, 41, 7))); //5개일치, 보너스볼 일치

        Lottos lottos = new Lottos(lottoList);

        WinNum winNum = new WinNum(Arrays.asList(1, 8, 11, 31, 41, 44), bonus);
        //when
        LotteryStatics lotteryStatics = new LotteryStatics(buyCount, lottos, winNum);

        //then
        double expected = (double) (30_000_000 + 5_000) / buyCount;

        assertThat(lotteryStatics.getGross()).isEqualTo(expected);
    }
}