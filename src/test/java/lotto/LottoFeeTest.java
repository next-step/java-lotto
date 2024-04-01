package lotto;

import lotto.domain.LottoFee;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoFeeTest {
    @Test
    @DisplayName("입력값 몇게임인지 파악하는 메서드")
    void 몇게임() {
        assertThat(new LottoFee(14000).convertToGameUnit()).isEqualTo(14);
    }
}
