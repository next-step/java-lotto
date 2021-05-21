package study.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PurchasedLottoTest {

    @DisplayName("주어진 장수만큼 로또를 구매한다")
    @Test
    public void lottoPapersTest(){
        PurchasedLotto purchasedLotto = new PurchasedLotto(3);
        assertThat(purchasedLotto.values().size()).isEqualTo(3);
    }

}