package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResultTest {

    private LottoResult lottoResult;

    @BeforeEach
    void init() {
        Lotto lotto = new Lotto((Arrays.asList(1, 2, 3, 4, 5, 6)));
        Lotto winnigLotto = new Lotto((Arrays.asList(1, 2, 3, 10, 11, 12)));
        WinningLotto winningLotto = new WinningLotto(winnigLotto);
        Lottos lottos = new Lottos(Arrays.asList(lotto));

        lottoResult = new LottoResult(winningLotto, lottos);
    }


    @Test
    @DisplayName("1개의 4등 당첨 로또가 있기때문에 총 당첨금액은 5,000원이다. ")
    void calcTotalWinningPrice() {
        Money returnRate = lottoResult.calcTotalWinningPrice(lottoResult.findWinningRanks());
        assertThat(returnRate.getMoney()).isEqualTo(new BigDecimal(5000));
    }

    @Test
    @DisplayName("1개의 4등 당첨 로또가 있기 때문에, 1개의 4등 당첨결과를 가지고있다.")
    void findWinningRanks() {
        List<Rank> winningRanks = lottoResult.findWinningRanks();

        assertThat(winningRanks).hasSize(1).contains(Rank.FOURTH);
    }
}