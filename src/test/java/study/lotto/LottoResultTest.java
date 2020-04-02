package study.lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.lotto.domain.*;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {
    private List<Lotto> lottos;
    private LottoWinningNumber lottoWinningNumber;

    @BeforeEach
    void setUp() {
        lottos = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 45))
        );
        lottoWinningNumber = new LottoWinningNumber(Arrays.asList(1, 2, 3, 4,
                5, 6), 45);
    }

    @DisplayName("로또 결과를 계산하여 저장할 수 있다.")
    @Test
    void addWinner() {
        LottoResult lottoResult = new LottoResult(lottos,
                lottoWinningNumber, 1000);

        assertThat(lottoResult.getWinningTickets(LottoRank.FIRST).size())
                .isEqualTo(1);
        assertThat(lottoResult.getWinningTickets(LottoRank.SECOND).size())
                .isEqualTo(1);
        assertThat(lottoResult.getWinningTickets(LottoRank.THIRD).size())
                .isEqualTo(0);
    }

    @DisplayName("수익률을 구할 수 있다.")
    @Test
    void getRateOfReturn() {
        List<Lotto> lottos = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6))
        );
        LottoWinningNumber lottoWinningNumber =
                new LottoWinningNumber(Arrays.asList(4,
                        5, 6, 7, 8, 9), 45);
        LottoResult lottoResult = new LottoResult(lottos,
                lottoWinningNumber, 50000);
        assertThat(lottoResult.getRateOfReturn()).isEqualTo(0.1);
    }
}
