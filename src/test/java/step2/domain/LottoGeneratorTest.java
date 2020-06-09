package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step2.Constants;
import step2.domain.enums.WinnerPriceEnum;
import step2.domain.strategy.TestLottoGeneratorStrategy;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("LottoGenerator 테스트")
class LottoGeneratorTest {

    private int lottoAmount = 3;
    private LottoGenerator lottoGenerator = new LottoGenerator(lottoAmount, new TestLottoGeneratorStrategy());

    @DisplayName("로또 총 당첨금 계산")
    @Test
    void calcTotalPrice() {
        assertThat(lottoGenerator.calcTotalPrice()).isEqualTo(0);
        lottoGenerator.generate();
        lottoGenerator.calcLottoWinCount(Constants.TEST_WINNER_NUMBERS);
        assertThat(lottoGenerator.calcTotalPrice()).isEqualTo(WinnerPriceEnum.MATCH_6.price);
    }

    @DisplayName("로또 수익률 계산")
    @ParameterizedTest
    @CsvSource(delimiter = ':', value = {"15000:5.00","0:0","300000:100.00"})
    void calcWinnerRatio(int totalPrice, String ratio) {
        assertThat(lottoGenerator.calcWinnerRatio(lottoAmount, totalPrice)).isEqualTo(ratio);
    }
}
