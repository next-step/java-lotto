package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoWinningResultTest {

    @Test
    @DisplayName("로또번호가 모두 일치하지 않을때 당첨금을 확인한다")
    void checkWinningAmount() {
        // given
        Map<LottoWinningAmount, Long> winningResultMap = new HashMap<>();
        LottoWinningResult lottoWinningResult = LottoWinningResult.of(winningResultMap);
        // when
        Long winningAmount = lottoWinningResult.getTotalWinningAmount();
        // then
        assertThat(winningAmount).isEqualTo(0);
    }

    @Test
    @DisplayName("로또번호가 3개 일치할때 당첨금을 확인한다")
    void checkWinningAmount2() {
        // given
        Map<LottoWinningAmount, Long> winningResultMap = new HashMap<>();
        winningResultMap.put(LottoWinningAmount.THREE_MATCH, 1L);
        LottoWinningResult lottoWinningResult = LottoWinningResult.of(winningResultMap);
        // when
        Long winningAmount = lottoWinningResult.getTotalWinningAmount();
        // then
        assertThat(winningAmount).isEqualTo(LottoWinningAmount.THREE_MATCH.getWinningAmount());
    }

    @Test
    @DisplayName("로또번호가 4개 일치할때 당첨금을 확인한다")
    void checkWinningAmount3() {
        // given
        Map<LottoWinningAmount, Long> winningResultMap = new HashMap<>();
        winningResultMap.put(LottoWinningAmount.FOUR_MATCH, 1L);
        LottoWinningResult lottoWinningResult = LottoWinningResult.of(winningResultMap);
        // when
        Long winningAmount = lottoWinningResult.getTotalWinningAmount();
        // then
        assertThat(winningAmount).isEqualTo(LottoWinningAmount.FOUR_MATCH.getWinningAmount());
    }

    @Test
    @DisplayName("로또번호가 5개 일치할때 당첨금을 확인한다")
    void checkWinningAmount4() {
        // given
        Map<LottoWinningAmount, Long> winningResultMap = new HashMap<>();
        winningResultMap.put(LottoWinningAmount.FIVE_MATCH, 1L);
        LottoWinningResult lottoWinningResult = LottoWinningResult.of(winningResultMap);
        // when
        Long winningAmount = lottoWinningResult.getTotalWinningAmount();
        // then
        assertThat(winningAmount).isEqualTo(LottoWinningAmount.FIVE_MATCH.getWinningAmount());
    }

    @Test
    @DisplayName("로또번호가 6개 일치할때 당첨금을 확인한다")
    void checkWinningAmount5() {
        // given
        Map<LottoWinningAmount, Long> winningResultMap = new HashMap<>();
        winningResultMap.put(LottoWinningAmount.SIX_MATCH, 1L);
        LottoWinningResult lottoWinningResult = LottoWinningResult.of(winningResultMap);
        // when
        Long winningAmount = lottoWinningResult.getTotalWinningAmount();
        // then
        assertThat(winningAmount).isEqualTo(LottoWinningAmount.SIX_MATCH.getWinningAmount());
    }

    @Test
    @DisplayName("로또번호가 복합적으로 일치할때 당첨금을 확인한다")
    void checkWinningAmount6() {
        // given
        Map<LottoWinningAmount, Long> winningResultMap = new HashMap<>();
        winningResultMap.put(LottoWinningAmount.THREE_MATCH, 2L);
        winningResultMap.put(LottoWinningAmount.FOUR_MATCH, 2L);
        winningResultMap.put(LottoWinningAmount.FIVE_MATCH, 1L);
        winningResultMap.put(LottoWinningAmount.SIX_MATCH, 1L);
        LottoWinningResult lottoWinningResult = LottoWinningResult.of(winningResultMap);
        // when
        Long winningAmount = lottoWinningResult.getTotalWinningAmount();
        // then
        assertThat(winningAmount).isEqualTo(LottoWinningAmount.THREE_MATCH.getWinningAmount() * 2 +
                LottoWinningAmount.FOUR_MATCH.getWinningAmount() * 2 +
                LottoWinningAmount.FIVE_MATCH.getWinningAmount() +
                LottoWinningAmount.SIX_MATCH.getWinningAmount());
    }

    @Test
    @DisplayName("로또 구입금액 대비 50% 수익률을 확인한다")
    void checkEarningRate() {
        // given
        Map<LottoWinningAmount, Long> winningResultMap = new HashMap<>();
        winningResultMap.put(LottoWinningAmount.THREE_MATCH, 1L);
        LottoWinningResult lottoWinningResult = LottoWinningResult.of(winningResultMap);
        // when
        double earningRate = lottoWinningResult.getEarningRate(PurchaseAmount.of(LottoWinningAmount.THREE_MATCH.getWinningAmount() * 2));
        // then
        assertThat(earningRate).isEqualTo(0.5);
    }

    @Test
    @DisplayName("로또 구입금액 대비 0% 수익률을 확인한다")
    void checkEarningRate2() {
        // given
        Map<LottoWinningAmount, Long> winningResultMap = new HashMap<>();
        LottoWinningResult lottoWinningResult = LottoWinningResult.of(winningResultMap);
        // when
        double earningRate = lottoWinningResult.getEarningRate(PurchaseAmount.of(10000L));
        // then
        assertThat(earningRate).isEqualTo(0.0);
    }

    @Test
    @DisplayName("로또 구입금액 대비 100% 수익률을 확인한다")
    void checkEarningRate3() {
        // given
        Map<LottoWinningAmount, Long> winningResultMap = new HashMap<>();
        winningResultMap.put(LottoWinningAmount.THREE_MATCH, 1L);
        LottoWinningResult lottoWinningResult = LottoWinningResult.of(winningResultMap);
        // when
        double earningRate = lottoWinningResult.getEarningRate(PurchaseAmount.of(LottoWinningAmount.THREE_MATCH.getWinningAmount()));
        // then
        assertThat(earningRate).isEqualTo(1.0);
    }
}
