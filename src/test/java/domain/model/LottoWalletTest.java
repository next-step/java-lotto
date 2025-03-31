package domain.model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoWalletTest {
    @Test
    void addTest() {
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(7, 8, 9, 10, 11, 12));

        LottoWallet lottoWallet = new LottoWallet();

        lottoWallet.addLottos(List.of(lotto1, lotto2));

        List<Lotto> lottos = lottoWallet.getLottos();
        assertThat(lottos).containsExactlyInAnyOrder(lotto1, lotto2);
    }
}
