package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LottosTest {

    @Test
    @DisplayName("로또들을 추가")
    public void created() {
        Lottos lottos = new Lottos();
        LottoNumbers lottoNumbers = new LottoNumbers(
                Arrays.asList(
                        new Number(1),
                        new Number(2),
                        new Number(3),
                        new Number(4),
                        new Number(5),
                        new Number(6)
                )
        );
        lottos.add(lottoNumbers);
        assertThat(lottos.getPickNumbers().size()).isEqualTo(1);
    }

    @Test
    @DisplayName("당첨번호와 비교")
    public void compareWinningNumber() {
        Lottos lottos = new Lottos();
        LottoNumbers lottoNumbers = new LottoNumbers(
                Arrays.asList(
                        new Number(1),
                        new Number(2),
                        new Number(3),
                        new Number(4),
                        new Number(5),
                        new Number(6)
                )
        );
        WinningNumbers winningNumbers = new WinningNumbers(
                new LottoNumbers(
                        Arrays.asList(
                                new Number(1),
                                new Number(2),
                                new Number(3),
                                new Number(4),
                                new Number(5),
                                new Number(6)
                        )
                ),
                new Number(7)
        );
        lottos.add(lottoNumbers);
        LottoAggregator lottoAggregator = lottos.matchWinningNumber(winningNumbers);
        assertThat(lottoAggregator.getCount(LottoRank.FIRST)).isEqualTo(1);
    }
}