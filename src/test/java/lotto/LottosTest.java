package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("로또 컬렉션 테스트")
public class LottosTest {

    @DisplayName("로또는 지불한 구입금액만큼 생성되어야 한다.")
    @Test
    public void generateLottoAsMuchAsPurchaseAmountTest() {
        // given
        int purchaseAmount = 14000;

        // when
        Lottos lottos = new Lottos(purchaseAmount);

        // then
        assertEquals(14, lottos.getSize());
    }
}
