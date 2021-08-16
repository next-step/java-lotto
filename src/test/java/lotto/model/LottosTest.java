package lotto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {
    private Lottos lottos;
    private WinningLotto winningLotto;

    @BeforeEach
    void setUp() {
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            List<LottoNumber> lotto = new ArrayList<>();
            for (int j = 1; j <= 6; j++) {
                lotto.add(LottoNumber.of(i * j));
            }
            lottoList.add(new Lotto(lotto));
        }
        lottos = new Lottos(lottoList);

        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            lottoNumbers.add(LottoNumber.of(1 + 2 * i));
        }
        Lotto winningNumbers = new Lotto(lottoNumbers);
        LottoNumber bonusNumber = LottoNumber.of(13);
        winningLotto = new WinningLotto(winningNumbers, bonusNumber);
    }

    @DisplayName(value = "당첨결과집계")
    @Test
    void count_winning_results() {
        Map<WinningResult, Integer> winningResults = lottos.countWinningResults(winningLotto).getWinningResults();
        assertThat(winningResults.get(WinningResult.NO_PRICE)).isEqualTo(2);
        assertThat(winningResults.get(WinningResult.FIFTH_PRICE)).isEqualTo(1);
        assertThat(winningResults.get(WinningResult.FOURTH_PRICE)).isEqualTo(0);
        assertThat(winningResults.get(WinningResult.THIRD_PRICE)).isEqualTo(0);
        assertThat(winningResults.get(WinningResult.SECOND_PRICE)).isEqualTo(0);
        assertThat(winningResults.get(WinningResult.FIRST_PRICE)).isEqualTo(0);
    }
}
