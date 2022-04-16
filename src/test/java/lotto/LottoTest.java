package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LottoTest {

    @Test
    @DisplayName("사용자가 입력한 금액에 따른 발급할 로또 개수 테스트")
    void lotteryTickerPer1000() {
        assertThat(12345 / 1000).isEqualTo(12);
    }
}
