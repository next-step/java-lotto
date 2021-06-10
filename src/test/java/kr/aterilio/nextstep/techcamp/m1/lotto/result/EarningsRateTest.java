package kr.aterilio.nextstep.techcamp.m1.lotto.result;

import kr.aterilio.nextstep.techcamp.m1.utils.StringUtil;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class EarningsRateTest {

    private static final int UNIT_POINT_POSITION = 2;

    @ParameterizedTest
    @CsvSource(value = {
            "2000000000,1000,2000000.00",
            "30000000,1000,30000.00",
            "1500000,1000,1500.00",
            "50000,1000,50.00",
            "5000,1000,5.00",
            "0,1000,0.00",
            "2031555000,6000,338592.50",
            "2031605000,6000,338600.84",
            "5000,14000,0.35",
    }, delimiter = ',')
    public void calculateEarningRate(int prize, int paid, String expected) {
        EarningsRate earningsRate = new EarningsRate(prize, paid);
        String expectedRate = StringUtil.floorFloatWithPointPosition(earningsRate.value(), UNIT_POINT_POSITION);
        assertThat(expectedRate).isEqualTo(expected);
    }
}
