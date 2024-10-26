package lotto;

import lotto.model.PrizeInfo;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PrizeInfoTest {
    PrizeInfo prizeInfo = new PrizeInfo(5000, 3);

    @Test
    public void 당첨_개수_증가() {
        assertThat(prizeInfo.getWinningCount()).isEqualTo(3);
        prizeInfo.increaseWinningCount();
        assertThat(prizeInfo.getWinningCount()).isEqualTo(4);
    }

    @Test
    public void 당첨금_계산() {
        assertThat(prizeInfo.calculateTotalPrize()).isEqualTo(15000);
    }

}
