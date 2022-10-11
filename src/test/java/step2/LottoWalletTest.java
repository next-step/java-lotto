package step2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import step2.domian.Lotto;
import step2.domian.LottoWallet;

import java.util.List;

public class LottoWalletTest {

    @Test
    void 로또_지난주로또와_비교() {
        Lotto lastWinner = new Lotto(List.of(1, 2, 3, 4, 5));
        Lotto lotto1 = new Lotto(List.of(3, 4, 5, 6, 7));
        Lotto lotto2 = new Lotto(List.of(1, 2, 3, 6, 7));

        Assertions.assertThat(new LottoWallet(List.of(lotto1, lotto2)).compareWithLastLotto(lastWinner).get(3)).isEqualTo(2);
    }
}
