package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoCalculationTest {

    private static final int price = 14000;
    private static final int expectedLotto = 14;

    @DisplayName("로또를_몇개_살수_있는지_계산")
    @Test
    void countLottoesTest() {
        Money money = new Money(price);
        LottoCalculation lottoCalculation = new LottoCalculation(money);
        assertThat(lottoCalculation.lottoCalculation()).isEqualTo(expectedLotto);
    }
}
