package lotto;

import lotto.model.PrizeRecord;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PrizeRecordTest {
    PrizeRecord prizeRecord = new PrizeRecord(5000, 3);

    @Test
    @DisplayName("당첨 개수 증가 테스트")
    public void increaseWinningCount() {
        assertThat(prizeRecord.getWinningCount()).isEqualTo(3);
        prizeRecord.increaseWinningCount();
        assertThat(prizeRecord.getWinningCount()).isEqualTo(4);
    }

    @Test
    @DisplayName("등수에 대한 총 당첨금 계산 테스트")
    public void calculateTotalPrize() {
        assertThat(prizeRecord.calculateTotalPrize()).isEqualTo(15000);
    }

}
