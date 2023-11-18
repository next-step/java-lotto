package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LottoAmountTest {

    @Test
    @DisplayName("구입 금액을 입력받아 구입 금액을 생성할 수 있다.")
    void createLottoAmountTest() {
        // given
        String inupt = "1000";

        // when
        LottoAmount lottoAmount = new LottoAmount(inupt);

        // then
        assertThat(lottoAmount).isEqualTo(new LottoAmount("1000"));
    }
}
