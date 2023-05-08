package util;

import domain.Lotto;
import domain.LottoResult;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoManagerTest {

    @Test
    @DisplayName("로또 구매 금액과 당첨 금액을 입력하면 수익률을 계산한다")
    void calculateProfitRate() {
        // given
        int purchaseAmount = 10000;
        int winningMoney = 20000;

        // when
        float profitRate = LottoManager.calculateProfitRate(purchaseAmount, winningMoney);

        // then
        assertThat(profitRate).isEqualTo(2);
    }

    @Test
    @DisplayName("로또 결과를 입력하면 총 당첨 금액을 계산한다")
    void sumOfLottoResult() {
        // given
        LottoResult lottoResult1 = LottoResult.FORTH;
        LottoResult lottoResult2 = LottoResult.FORTH;

        // when
        int sumOfLottoResult = LottoManager.sumOfLottoResult(List.of(lottoResult1, lottoResult2));

        // then
        assertThat(sumOfLottoResult).isEqualTo(100000);
    }

    @Test
    @DisplayName("아무 조건 없이 로또를 생성한다")
    void createLotto() {
        Lotto lotto = LottoManager.createLotto();
        assertThat(lotto).isNotNull();
    }
}