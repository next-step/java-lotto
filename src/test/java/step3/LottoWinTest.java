package step3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.model.LottoWin;
import step3.model.Money;
import step3.model.Reward;

@DisplayName("LottoWin 클래스 테스트")
public class LottoWinTest {

    @DisplayName("총 수익금액을 잘 계산하는지 테스트")
    @Test
    void totalReward() {
        Map<Reward, Long> rewardMap = new HashMap<>();
        rewardMap.put(Reward.FIFTH, 1L);
        rewardMap.put(Reward.FOURTH, 1L);
        LottoWin lottoWin = new LottoWin(rewardMap);
        Money total = lottoWin.totalReward();

        assertEquals(new Money(55_000), total);
    }
}
