package lotto.domain.model;

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
        lottoWallet.addLotto(lotto1);
        lottoWallet.addLotto(lotto2);

        List<LottoNumbers> lottos = lottoWallet.getLottos();
        assertThat(lottos).containsExactlyInAnyOrder(lotto1, lotto2);
        assertThat(lottoWallet.getCount()).isEqualTo(2);
    }

    @DisplayName("로또 번호를 비교하여 일치하는 개수를 센다.")
    @Test
    void countMatchTest() {
        LottoNumbers lotto1 = new LottoNumbers(List.of(1, 2, 3, 4, 5, 6));
        LottoNumbers lotto2 = new LottoNumbers(List.of(7, 8, 9, 10, 11, 12));
        LottoNumbers winNumbers = new LottoNumbers(List.of(1, 2, 3, 7, 8, 9));

        LottoWallet lottoWallet = new LottoWallet();
        lottoWallet.addLotto(lotto1);
        lottoWallet.addLotto(lotto2);

        MatchResult result = lottoWallet.countMatches(winNumbers);

        assertThat(result.getCount(3)).isEqualTo(1);
        assertThat(result.getCount(4)).isEqualTo(0);
        assertThat(result.getCount(5)).isEqualTo(0);
        assertThat(result.getCount(6)).isEqualTo(0);
    }
}
