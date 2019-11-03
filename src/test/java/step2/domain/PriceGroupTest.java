package step2.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class PriceGroupTest {

    @ParameterizedTest
    @CsvSource(value = {"0,0", "3,5000", "6,2000000000"})
    void 맞춘갯수로_당첨금액_가져오기(Integer matchAmount, Long answerPrice) {
        Long resultPrice = PriceGroup.findPriceByMatchAmount(matchAmount);

        assertThat(resultPrice).isEqualTo(answerPrice);
    }
}