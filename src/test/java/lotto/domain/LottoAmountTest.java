package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

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

    @Test
    @DisplayName("1000원 단위가 아닌 경우 예외가 발생한다.")
    void createLottoAmountUnitTest() {
        // given
        String input = "1001";

        // when & then
        assertThatThrownBy(() -> new LottoAmount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1000원 단위로 입력해주세요.");
    }

    @Test
    @DisplayName("구입 금액이 숫자가 아닌 경우 예외가 발생한다.")
    void createLottoAmountTypeTest() {
        // given
        String input = "A";

        // when & then
        assertThatThrownBy(() -> new LottoAmount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자만 입력할 수 있습니다.");
    }
}
