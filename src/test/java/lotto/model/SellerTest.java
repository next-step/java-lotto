package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class SellerTest {
    @Test
    void 당첨로또를_판매자에_저장한다() {
        Assertions.assertThatNoException().isThrownBy(() -> {
            Seller actual = Seller.of(Lotto.of(() -> new Integer[]{1, 2, 3, 4, 5, 6}));
        });
    }

    @Test
    void 당첨로또번호목록을_출력한다() {
        Lotto actual = Seller.of(Lotto.of(() -> new Integer[]{1, 2, 3, 4, 5, 6})).winnerLotto();
        Lotto expected = Lotto.of(() -> new Integer[]{1, 2, 3, 4, 5, 6});
        Assertions.assertThat(actual).isEqualTo(expected);
    }
}
