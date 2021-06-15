package lottoAuto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LottoCalculatorTest {

    @DisplayName("로또 계산기는 로또를 몇 장 살 수 있는지 계산할 수 있다.")
    @Test
    public void calculateAmountTest() {
        LottoCalculator lottoCalculator = new LottoCalculator();

        assertThat(4).isEqualTo(lottoCalculator.calculateAmount(4000));
    }

    @DisplayName("로또 계산기는 로또 1장 가격 이하이면 예외를 발생시킨다.")
    @Test
    public void checkLottoPriceTest() {
        LottoCalculator lottoCalculator = new LottoCalculator();

        assertThrows(IllegalArgumentException.class, () -> lottoCalculator.calculateAmount(500));
    }
}
