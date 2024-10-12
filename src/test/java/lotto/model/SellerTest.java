package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class SellerTest {
    @Test
    void 당첨로또를_판매자에_저장한다() {
        Assertions.assertThatNoException().isThrownBy(() -> {
            Seller actual = Seller.of(Lotto.of(1, 2, 3, 4, 5, 6));
        });
    }
}
