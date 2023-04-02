package automaticlotto;

import automaticlotto.domain.Lotto;
import automaticlotto.domain.LottoNumber;
import automaticlotto.domain.LottoWinning;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoWinningTest {

    @DisplayName("당첨번호 확인")
    @Test
    void discriminateLottoNumberTest() {
        Lotto lotto;
        Lotto winningLotto;
        List<Integer> lottoResult = new ArrayList<>(Collections.nCopies(7, 0));
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        List<LottoNumber> winningLottoNumbers = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            lottoNumbers.add(new LottoNumber(i + 3));
            winningLottoNumbers.add(new LottoNumber(i + 1));
        }
        lotto = new Lotto(lottoNumbers);
        winningLotto = new Lotto(winningLottoNumbers);
        assertThat(new LottoWinning().discriminateLottoNumber(lotto, winningLotto, lottoResult)).containsExactly(0, 0, 0, 0, 1, 0, 0);
    }

    @DisplayName("당첨금액 확인")
    @Test
    void rankLottoWinner() {
        List<Integer> lottoResult = Arrays.asList("0", "1", "0", "2", "1", "0", "0").stream().map(s -> Integer.parseInt(s)).collect(Collectors.toList());
        assertThat(new LottoWinning().rankLottoWinner(lottoResult)).isEqualTo(60000);
    }

    @DisplayName("수익률 확인")
    @Test
    void revenueRateTest() {
        assertThat(new LottoWinning().revenueRate(2000, 5000)).isEqualTo("2.50");
    }
}
