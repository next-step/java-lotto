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

    @DisplayName("로또 번호를 비교하여 일치하는 개수를 센다.")
    @Test
    void countMatchTest() {
        LottoNumbers lotto1 = new LottoNumbers(List.of(1, 2, 3, 4, 5, 6));
        LottoNumbers lotto2 = new LottoNumbers(List.of(7, 8, 9, 10, 11, 12));
        LottoNumbers winningNumbers = new LottoNumbers(List.of(1, 2, 3, 7, 8, 9));

        LottoWallet lottoWallet = new LottoWallet();
        lottoWallet.addLottos(List.of(lotto1, lotto2));

        lottoWallet.countMatches(winningNumbers);

        assertThat(lotto1.getMatchCount()).isEqualTo(3);
        assertThat(lotto2.getMatchCount()).isEqualTo(0);
    }

    @DisplayName("로또 번호의 일치 결과를 반환한다.")
    @Test
    void getMatchResultTest() {
        LottoNumbers lotto1 = new LottoNumbers(List.of(1, 2, 3, 4, 5, 6));
        LottoNumbers lotto2 = new LottoNumbers(List.of(7, 8, 9, 10, 11, 12));
        LottoNumbers winningNumbers = new LottoNumbers(List.of(1, 2, 3, 7, 8, 9));

        LottoWallet lottoWallet = new LottoWallet();
        lottoWallet.addLottos(List.of(lotto1, lotto2));

        lottoWallet.countMatches(winningNumbers);

        assertThat(lottoWallet.getMatchResult()).containsEntry(3, 1);
    }

    @DisplayName("로또 번호의 총 당첨 금액을 반환한다.")
    @Test
    void getPrizeTest() {
        LottoNumbers lotto1 = new LottoNumbers(List.of(1, 2, 3, 4, 5, 6));
        LottoNumbers lotto2 = new LottoNumbers(List.of(7, 8, 9, 10, 11, 12));
        LottoNumbers winningNumbers = new LottoNumbers(List.of(1, 2, 3, 7, 8, 9));

        LottoWallet lottoWallet = new LottoWallet();
        lottoWallet.addLottos(List.of(lotto1, lotto2));

        lottoWallet.countMatches(winningNumbers);

        assertThat(lottoWallet.getPrize()).isEqualTo(0); // Assuming no prize for this test case
    }
}
