package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @DisplayName("로또의 가격은 1000원이다")
    @Test
    void price() {
        assertThat(Lotto.PRICE).isEqualTo(1000);
    }
}
