package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("로또 컬렉션 테스트")
public class LottosTest {

    @DisplayName("로또는 지불한 구입금액만큼 생성되어야 한다.")
    @Test
    public void generateLottoAsMuchAsPurchaseAmountTest() {
        // given
        int purchaseAmount = 14000;
        int manualLottoCount = 0;

        // when
        Lottos lottos = new Lottos(purchaseAmount, manualLottoCount);

        // then
        assertEquals(14, lottos.getSize());
    }

    @DisplayName("로또 1개 가격보다 구입금액이 적으면 예외가 발생한다.")
    @Test
    public void purchaseAmountLessThanOneLottoPriceExceptionTest() {
        // given
        int purchaseAmount = 500;
        int manualLottoCount = 0;

        // when, then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Lottos(purchaseAmount, manualLottoCount))
                .withMessage("구입금액은 최소 1000(원) 이상이어야 합니다.");
    }

    @DisplayName("수동 로또 개수가 0개 미만이면 예외가 발생한다.")
    @Test
    public void manualLottoCountLessThanZeroExceptionTest() {
        // given
        int purchaseAmount = 10000;
        int manualLottoCount = -1;

        // when, then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Lottos(purchaseAmount, manualLottoCount))
                .withMessage("수동 로또 개수는 최소 0개 이상이어야 합니다.");
    }
}
