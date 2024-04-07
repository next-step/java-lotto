package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoFeeTest {
    @Test
    @DisplayName("입력값 몇게임인지 파악하는 메서드")
    void 몇게임() {
        LottoFee lottoFee = new LottoFee(14000);
        assertThat(lottoFee.totalCount()).isEqualTo(14);
    }
}
