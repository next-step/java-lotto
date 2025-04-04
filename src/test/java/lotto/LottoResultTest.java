package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoResultTest {

    private final static int LOTTO_PRIZE = 1000;

    @Test
    @DisplayName("전체 구매 금액과 당첨 금액을 입력받아 수익률을 계산할 수 있다.")
    void shouldCalculateProfitRate() {
        assertThat(LottoResult.calculateProfitRate(LOTTO_PRIZE * 10, LOTTO_PRIZE)).isEqualTo(0.1);
    }

}
