package lottery;

import lottery.domain.RateOfReturn;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class RateOfReturnTest {

    @DisplayName("수익률이 1 이상이면 true, 아니면 false 리턴")
    @ParameterizedTest
    @CsvSource({"3, true", "1, true", "0.7, false"})
    public void getBooleanOnRateOfReturn(double rateOfReturn, boolean result) {
        RateOfReturn rateOfReturnObject = new RateOfReturn(rateOfReturn);

        assertThat(rateOfReturnObject.isSurplus()).isEqualTo(result);
    }
}
