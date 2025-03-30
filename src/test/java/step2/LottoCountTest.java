package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.domain.LottosCount;

import static org.assertj.core.api.Assertions.*;

public class LottoCountTest {
    @Test
    @DisplayName("수동 로또 구매 개수가 구매 금액을 초과할경우 에러")
    void manualCountFail() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottosCount(3, 2000));
    }

    @Test
    void lottosCount() {
        LottosCount lottosCount = new LottosCount(3, 10000);
        assertThat(lottosCount.getAuto()).isEqualTo(7);
        assertThat(lottosCount.getManual()).isEqualTo(3);
    }
}
