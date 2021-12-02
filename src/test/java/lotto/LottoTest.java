package lotto;

import lotto.domain.Lotto;
import lotto.domain.Store;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @DisplayName("로또 1장은 1000원")
    @Test
    void 금액만큼_로또구매() {
        List<Lotto> lottos = Store.buy(10000);
        assertThat(lottos.size()).isEqualTo(10);
    }

}
