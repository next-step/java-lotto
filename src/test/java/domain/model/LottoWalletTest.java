package domain.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoWalletTest {
    @DisplayName("로또를 추가한다.")
    @Test
    void addTest() {
        LottoNumbers lotto1 = new LottoNumbers(List.of(1, 2, 3, 4, 5, 6));
        LottoNumbers lotto2 = new LottoNumbers(List.of(7, 8, 9, 10, 11, 12));

        LottoWallet lottoWallet = new LottoWallet();

        lottoWallet.addLottos(List.of(lotto1, lotto2));

        List<LottoNumbers> lottos = lottoWallet.getLottos();
        assertThat(lottos).containsExactlyInAnyOrder(lotto1, lotto2);
    }
}
