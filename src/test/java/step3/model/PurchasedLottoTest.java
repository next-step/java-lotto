package step3.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/*
- 당첨번호를 입력받는다.
*/
public class PurchasedLottoTest extends GlobalTest {

    @DisplayName("당첨번호를 입력받는다.")
    @Test
    void addLottoNumTest() {
        PurchasedLotto purchasedLotto = new PurchasedLotto();
        purchasedLotto.addLotto(createLotto(1, 2, 3, 4, 5, 6));
        purchasedLotto.addLotto(createLotto(7, 8, 9, 10, 11, 12));

        assertThat(purchasedLotto.getPurchasedLotto())
                .containsExactlyInAnyOrder(
                        createLotto(1, 2, 3, 4, 5, 6),
                        createLotto(7, 8, 9, 10, 11, 12)
                );
    }
}
