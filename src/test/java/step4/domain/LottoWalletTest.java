package step4.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LottoWalletTest {

    @Test
    void 로또_지난주로또와_비교() {
        Lotto lotto1 = new Lotto(List.of(3, 4, 5, 6, 7, 8));
        Lotto lotto2 = new Lotto(List.of(1, 2, 3, 6, 7, 8));
        Assertions.assertThat(new LottoWallet(List.of(lotto1, lotto2)).compareWithLastLotto(new LastWinner(List.of(1, 2, 3, 4, 5, 6), 9)).getResultCount(Prize.FOUR_PRIZE)).isEqualTo(2);
    }

    @Test
    void 보너스볼이_있을_경우() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Assertions.assertThat(new LottoWallet(List.of(lotto)).compareWithLastLotto(new LastWinner(List.of(1, 2, 3, 4, 5, 8), 5)).getResultCount(Prize.FIVE_BONUS_PRIZE)).isEqualTo(1);
    }
}
