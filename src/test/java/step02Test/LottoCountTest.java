package step02Test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step02.model.lotto.LottoCount;
import step02.model.lotto.LottoCountNumber;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoCountTest {

    @Test
    @DisplayName("남은 로또 갯수 테스트")
    void calculateRemainCount() {
        assertThat(LottoCount.calculationRemain(new LottoCountNumber(10), new LottoCountNumber(6))).isEqualTo(4);
    }
}
