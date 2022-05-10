package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@DisplayName(value = "수익률 테스트")
class ReturnRateTest {

    @ParameterizedTest(name = "{displayName} -> [{index}] : {0} / {1}  = {2}")
    @CsvSource(value = {"1000:100:10", "4:2:2"}, delimiter = ':')
    void 총_상금과_구매금액을_입력받아_수익률을_Wrapping_하는_객체_생성(int sumOfPurchase, int purchaseAmount, double result) {
        assertThat(new ReturnRate(sumOfPurchase, purchaseAmount)).isEqualTo(new ReturnRate(result));
    }

    @ParameterizedTest
    @CsvSource(value = {"0.9:false", "1.1:true"}, delimiter = ':')
    void 수익률을_기준_값과_비교해서_이득인지_손해인지_판단(double input, boolean result) {
        assertThat(new ReturnRate(input).isProfitable()).isEqualTo(result);
    }
}