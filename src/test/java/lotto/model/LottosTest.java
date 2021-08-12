package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("로또 컬렉션 테스트")
public class LottosTest {

    @DisplayName("로또는 지불한 구입금액만큼 생성되어야 한다.")
    @Test
    public void generateLottoAsMuchAsPurchaseAmountTest() {
        // given, when
        Lottos lottos = new Lottos(14000, new ArrayList<>());

        // then
        assertEquals(14, lottos.getSize());
    }

    @DisplayName("로또 1개 가격보다 구입금액이 적으면 예외가 발생한다.")
    @Test
    public void purchaseAmountLessThanOneLottoPriceExceptionTest() {
        // given, when, then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Lottos(500, new ArrayList<>()))
                .withMessage("구입금액은 최소 1000(원) 이상이어야 합니다.");
    }

    @DisplayName("수동 로또 개수가 구입 가능 개수를 초과하면 예외가 발생한다.")
    @Test
    public void manualLottoPriceMoreThanPurchaseAmountExceptionTest() {
        // given
        int purchaseAmount = 1000;
        List<Lotto> manualLottos = (Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new Lotto(Arrays.asList(7, 8, 9, 10, 11, 12))
        ));

        // when, then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Lottos(purchaseAmount, manualLottos))
                .withMessage("수동 로또 개수가 구입 가능 개수를 초과했습니다.");
    }
}
