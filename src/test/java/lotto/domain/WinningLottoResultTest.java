package lotto.domain;

import lotto.view.Output;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class WinningLottoResultTest {

    private WinningLottoResult winningLottoResult;

    @DisplayName("중복당첨일때 해당 해당 카운트2로 출력")
    @Test
    void matchAndGetResult() {
        WinningLottoResult winningLottoResultMulti = new WinningLottoResult();
        winningLottoResultMulti.match(6, false);
        winningLottoResultMulti.match(6, false);
        winningLottoResultMulti.match(2, true);
        Map<Prize, Integer> result = winningLottoResultMulti.getResult();
        assertThat(result.get(Prize.FIRST)).isEqualTo(2);
    }

    @DisplayName("당첨자가 없을때 0출력")
    @Test
    void matchAndGetResultWithZero() {
        WinningLottoResult winningLottoWithZero = new WinningLottoResult();
        winningLottoWithZero.match(2, true);
        winningLottoWithZero.match(1, false);
        winningLottoWithZero.match(2, false);

        Map<Prize, Integer> result = winningLottoWithZero.getResult();
        assertThat(result.get(Prize.FIRST)).isEqualTo(0);
        assertThat(result.get(Prize.SECOND)).isEqualTo(0);
        assertThat(result.get(Prize.THIRD)).isEqualTo(0);
        assertThat(result.get(Prize.FOURTH)).isEqualTo(0);
        assertThat(result.get(Prize.FIFTH)).isEqualTo(0);
    }

    @DisplayName("당첨자가 중복일때 출력")
    @Test
    void matchAndGetResultWithFirstTwoTimes() {
        WinningLottoResult winningLottoWithZero = new WinningLottoResult();
        winningLottoWithZero.match(6, false);
        winningLottoWithZero.match(3, false);
        winningLottoWithZero.match(6, false);

        Map<Prize, Integer> result = winningLottoWithZero.getResult();
        assertThat(result.get(Prize.FIRST)).isEqualTo(2);
        assertThat(result.get(Prize.SECOND)).isEqualTo(0);
        assertThat(result.get(Prize.THIRD)).isEqualTo(0);
        assertThat(result.get(Prize.FOURTH)).isEqualTo(0);
        assertThat(result.get(Prize.FIFTH)).isEqualTo(1);
    }

    @DisplayName("3게임중 1등 두번 5등 한번일때 수익률 계산")
    @Test
    void getRevenueStatic() {
        WinningLottoResult winningLottoWithZero = new WinningLottoResult();
        winningLottoWithZero.match(6, false);
        winningLottoWithZero.match(3, false);
        winningLottoWithZero.match(6, false);

        float revenueStatic = winningLottoWithZero.getRevenueStatic(3);
        assertThat(revenueStatic).isEqualTo((float) 1000000.0);
    }

    @DisplayName("3게임중 당첨된 번호가 없을때 수익률 계산")
    @Test
    void getRevenueStaticWithZero() {
        WinningLottoResult winningLottoWithZero = new WinningLottoResult();
        winningLottoWithZero.match(2, false);
        winningLottoWithZero.match(1, false);
        winningLottoWithZero.match(0, false);

        float revenueStatic = winningLottoWithZero.getRevenueStatic(3);
        assertThat(revenueStatic).isEqualTo((float) 0.0);
    }



    @DisplayName("수익률이 1이하일때 손해문구 반환")
    @Test
    void benefitOrLossWithLoss() {
        String result = winningLottoResult.benefitOrLoss((float) 0.8);
        assertThat(result).isEqualTo("손해");
    }

    @DisplayName("수익률이 1이상일때 이득문구 반환")
    @Test
    void benefitOrLossWithBenefit() {
        String result = winningLottoResult.benefitOrLoss((float) 10.5);
        assertThat(result).isEqualTo("이득");
    }

}