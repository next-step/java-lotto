package step3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.model.LottoPrize;
import step3.model.LottoWin;
import step3.model.Money;
import step3.model.Reward;

@DisplayName("LottoPrize 클래스 테스트코드 작성")
public class LottoPrizeTest {

    @DisplayName("getYield 메서드 테스트")
    @Test
    void getYield() {
        Map<Reward, Long> rewardMap = Reward.getDefaultRewardMap();
        rewardMap.put(Reward.FIFTH, 1L);
        LottoPrize lottoPrize = new LottoPrize(new LottoWin(rewardMap), Money.fromLottoBundleSize(14));
        assertEquals(0.36, Math.round(lottoPrize.totalYield() * 100) / 100.0);
    }

}
