package study.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PurchasedLottosTest {

    @DisplayName("주어진 장수만큼 로또를 구매한다")
    @Test
    public void lottoPapersTest(){
        PurchasedLottos purchasedLottos = new PurchasedLottos(3);
        assertThat(purchasedLottos.values().size()).isEqualTo(3);
    }

}