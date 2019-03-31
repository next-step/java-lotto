package lotto;

import lotto.domain.*;
import org.junit.Test;

import java.util.*;

import static lotto.controller.LotteryGame.main;
import static lotto.domain.TotalLotteries.getsInitializedMap;
import static lotto.domain.LotteryNo.makeLotteryNos;
import static org.assertj.core.api.Assertions.assertThat;
import static util.Random.generateRandom;
import static util.Random.makeNumber;


public class LotteryTest {
    @Test
    public void 로또_구매_문자열() {
        TotalLotteries totalLotteries = new TotalLotteries("1000");
        assertThat(totalLotteries.countPurchaseQuantity()).isEqualTo(1);
    }

    @Test
    public void 로또_구매_숫자() {
        TotalLotteries totalLotteries = new TotalLotteries(1000);
        assertThat(totalLotteries.countPurchaseQuantity()).isEqualTo(1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 금액입력_NULL_예외처리() {
        TotalLotteries.checkPurchaseValidation(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 금액입력_공백_예외처리() {
        TotalLotteries.checkPurchaseValidation("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void 최소_금액_예외처리() {
        TotalLotteries.checkPurchaseValidation("900");
    }

    @Test(expected = IllegalArgumentException.class)
    public void 로또_중복_입력_테스트() {
        final Set<LotteryNo> lotteryNumber = makeLotteryNos(Arrays.asList(1, 1, 2, 3, 4, 5, 6));

        new Lottery(lotteryNumber);
    }

    @Test
    public void 로또_생성_개수_검사() {
        TotalLotteries totalLotteries = new TotalLotteries("15000");

        assertThat(15).isEqualTo(totalLotteries.countPurchaseQuantity());
    }

    @Test
    public void 랭크_저장_테스트() {
        Map<String, Integer> ranks = getsInitializedMap();

        Ranking ranking = Ranking.FIRST_CLASS;
        ranking.makeRanks(ranks);

        assertThat(ranks.get("first")).isEqualTo(1);
    }

    @Test
    public void 랜덤값_생성개수_테스트() {
        Lottery random = generateRandom();

        assertThat(random.getLotterySize()).isEqualTo(6);
    }

    @Test
    public void 로또_생성전_랜덤개수_생성_테스트() {
        List<LotteryNo> numbers = makeNumber();

        assertThat(numbers.size()).isEqualTo(45);
    }

    @Test
    public void 로또_게임_테스트() {
        // 출력 테스트를 위한 main 함수
        main();
    }
}