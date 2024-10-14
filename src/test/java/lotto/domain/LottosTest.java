package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LottosTest {
    @Test
    @DisplayName("1등 2장 구매 당첨금")
    void getWinningAmount() {
        List<Integer> lottoNumber = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lottos lottos = getLottos(Arrays.asList(new Lotto(lottoNumber), new Lotto(lottoNumber)));
        assertThat(lottos.getWinningAmount(lottoNumber)).isEqualTo(LottoRankingEnum.FIRST_PRIZE.getWinningAmount().multiply(BigDecimal.valueOf(2)));
    }

    @Test
    @DisplayName("꽝 당첨금")
    void getWinningAmount2() {
        List<Integer> lottoNumber = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> winningNumber = Arrays.asList(7,8,9,10,11,12);
        Lottos lottos = getLottos(Arrays.asList(new Lotto(lottoNumber), new Lotto(lottoNumber)));
        assertThat(lottos.getWinningAmount(winningNumber)).isEqualTo(LottoRankingEnum.LOSING_LOT.getWinningAmount());
    }

    @Test
    @DisplayName("1당첨 건수 2건")
    void getWinningResult() {
        List<Integer> lottoNumber = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lottos lottos = getLottos(Arrays.asList(new Lotto(lottoNumber), new Lotto(lottoNumber)));
        assertThat(lottos.getWinningResult(lottoNumber).keySet()).hasSize(1);
        assertThat(lottos.getWinningResult(lottoNumber).get(LottoRankingEnum.FIRST_PRIZE)).isEqualTo(2);
    }

    @Test
    @DisplayName("3장 로또 구매 총금액")
    void getTotalPaymentAmount() {
        List<Integer> lottoNumber = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lottos lottos = getLottos(Arrays.asList(
                new Lotto(lottoNumber)
                ,new Lotto(lottoNumber)
                ,new Lotto(lottoNumber)));

        assertThat(lottos.getTotalPaymentAmount()).isEqualTo(BigDecimal.valueOf(3000));

    }

    @Test
    void getSize() {
        List<Integer> lottoNumber = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lottos lottos = getLottos(Arrays.asList(
                new Lotto(lottoNumber)
                ,new Lotto(lottoNumber)
                ,new Lotto(lottoNumber)));

        assertThat(lottos.getSize()).isEqualTo(3);

    }

    private Lottos getLottos(List<Lotto> lottoList) {
        return new Lottos(lottoList);
    }

}
