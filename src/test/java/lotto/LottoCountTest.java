package lotto;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import lotto.domain.game.LottoCount;
import lotto.domain.game.Payment;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoCountTest {

    @DisplayName("로또 카운트 객체 생성 성공")
    @Test
    void create() {
        Payment payment = new Payment(3000);
        int inputLottoManualCount = 2;

        assertDoesNotThrow(() -> new LottoCount(payment, inputLottoManualCount));
    }

    @DisplayName("투입 금액보다 수동 로또를 더 많이 살 경우 예외 발생")
    @Test
    void buyLottoManualMore() {
        Payment payment = new Payment(3000);
        int inputLottoManualCount = 4;

        Assertions.assertThatThrownBy(() -> new LottoCount(payment, inputLottoManualCount))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("투입 금액이 부족합니다");
    }

    @DisplayName("구입한 수동 로또 갯수를 정상 반환")
    @Test
    void getLottoManualCount() {
        Payment payment = new Payment(6000);
        int inputLottoManualCount = 5;
        LottoCount lottoCount = new LottoCount(payment, inputLottoManualCount);

        Assertions.assertThat(lottoCount.getManualCount()).isEqualTo(5);
    }

    @DisplayName("구입한 자동 로또 갯수를 정상 반환")
    @Test
    void getLottoAutoCount() {
        Payment payment = new Payment(6000);
        int inputLottoManualCount = 5;
        LottoCount lottoCount = new LottoCount(payment, inputLottoManualCount);

        Assertions.assertThat(lottoCount.getAutoCount()).isEqualTo(1);
    }

}
