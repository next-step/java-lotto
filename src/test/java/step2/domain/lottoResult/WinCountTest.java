package step2.domain.lottoResult;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class WinCountTest {
    @DisplayName("상금 계산이 올바른지 테스트")
    @Test
    void prize_Money_Test() {
        WinCount winCount = new WinCount(5);

        int result = winCount.moneyCount(3000);

        assertThat(result).isEqualTo(15000);
    }
}