package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {


    @Test
    @DisplayName("구입금액과 당첨금액을 바탕으로 수익률을 계산한다.")
    void should_calculate_rate_of_return() {
        //Given
        LottoAmount lottoAmount = new LottoAmount(14000);
        int prizeMoney = Rank.FOURTH.getPrizeMoney();

        //When
        double rate = Calculator.calculateRateOfReturn(lottoAmount.getAmount(), prizeMoney);

        //Then
        assertThat(rate).isEqualTo(0.35);
    }

}