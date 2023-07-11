package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

class LottoMoneyTest {
    @Test
    @DisplayName("로또 머니는 양수여야 한다.")
    void 로또_머니_양수_정상_동작() {
        assertThatCode(() -> new LottoMoney(14000))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("로또 머니가 음수일 경우, 예외를 던진다.")
    void 로또_머니_음수_예외() {
        assertThatCode(() -> new LottoMoney(-1))
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("로또 머니가 양수여야 합니다.");
    }

    @Test
    @DisplayName("금액에 따라 구매해야할 로또 개수를 반환")
    void 로또_개수() {
        LottoMoney lottoMoney = new LottoMoney(14000);

        int lottoCount = lottoMoney.getLottoCount();

        assertThat(lottoCount).isEqualTo(14);
    }


}