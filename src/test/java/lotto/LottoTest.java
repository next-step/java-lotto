package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class LottoTest {

    @Test
    void contain() {
        Lotto lotto = new Lotto("1, 2, 3, 4, 5, 6");
        Assertions.assertThat(lotto.contain(new LottoNumber(5))).isTrue();
        Assertions.assertThat(lotto.contain(new LottoNumber(7))).isFalse();
    }
}
