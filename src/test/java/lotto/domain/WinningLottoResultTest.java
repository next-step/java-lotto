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

    @BeforeEach
    void setUp() {
        winningLottoResult = new WinningLottoResult();
        winningLottoResult.match(6, Match.EMPTY);
        winningLottoResult.match(2, Match.HAS);
    }


    @DisplayName("중복당첨일때 해당 해당 카운트2로 출력")
    @Test
    void matchAndGetResult() {
        WinningLottoResult winningLottoResultMulti = new WinningLottoResult();
        winningLottoResultMulti.match(6, Match.EMPTY);
        winningLottoResultMulti.match(6, Match.EMPTY);
        winningLottoResultMulti.match(2, Match.HAS);
        Map<Prize, Integer> result = winningLottoResultMulti.getResult();
        assertThat(result.get(Prize.FIRST)).isEqualTo(2);
    }

    @DisplayName("당첨자가 없을때 0출력")
    @Test
    void matchAndGetResultWithZero() {
        WinningLottoResult winningLottoWithZero = new WinningLottoResult();
        winningLottoWithZero.match(2, Match.HAS);
        winningLottoWithZero.match(1, Match.EMPTY);
        winningLottoWithZero.match(2, Match.EMPTY);

        Map<Prize, Integer> result = winningLottoWithZero.getResult();
        assertThat(result.get(Prize.FIRST)).isEqualTo(0);
        assertThat(result.get(Prize.SECOND)).isEqualTo(0);
        assertThat(result.get(Prize.THIRD)).isEqualTo(0);
        assertThat(result.get(Prize.FOURTH)).isEqualTo(0);
        assertThat(result.get(Prize.FIFTH)).isEqualTo(0);
    }

    @DisplayName("2게임중 1등 한번일때 수익률 계산")
    @Test
    void getRevenueStatic() {
        float revenueStatic = winningLottoResult.getRevenueStatic(2);
        assertThat(revenueStatic).isEqualTo((float) 1000000.0);
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