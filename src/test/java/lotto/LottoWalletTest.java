package lotto;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoWalletTest {

    @Test
    void generate() {
        LottoWallet lottoWallet = new LottoWallet();
        lottoWallet.generateLotto(3);

        List<Lotto> lottos = lottoWallet.getLottos();
        assertThat(lottos).hasSize(3);
    }
}
