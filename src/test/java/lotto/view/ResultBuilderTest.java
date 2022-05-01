package lotto.view;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class ResultBuilderTest {

    @ParameterizedTest(name = "{0}의 수익률이 발생하면 다음 메시지를 반환한다. {1}")
    @CsvSource({"0.99,총 수익률은 0.99입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)",
            "1.00,총 수익률은 1.0입니다.(기준이 1이기 때문에 결과적으로 원점이라는 의미임)",
            "1.01,총 수익률은 1.01입니다.(기준이 1이기 때문에 결과적으로 이익이라는 의미임)"})
    void buildLottosProfitRate(double input, String expected) {
        assertThat(ResultBuilder.buildLottosProfitRate(input)).isEqualTo(expected);
    }
}