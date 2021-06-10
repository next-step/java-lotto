package kr.aterilio.nextstep.techcamp.m1.lotto.result;

import kr.aterilio.nextstep.techcamp.m1.utils.JUnitParser;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class PrizeMoneyTest {

    @ParameterizedTest
    @CsvSource(value = {
            "FIRST:1|SECOND:0|THIRD:0|FOURTH:0|FIFTH:0=2000000000",
            "FIRST:0|SECOND:1|THIRD:0|FOURTH:0|FIFTH:0=30000000",
            "FIRST:0|SECOND:0|THIRD:1|FOURTH:0|FIFTH:0=1500000",
            "FIRST:0|SECOND:0|THIRD:0|FOURTH:1|FIFTH:0=50000",
            "FIRST:0|SECOND:0|THIRD:0|FOURTH:0|FIFTH:1=5000",
            "FIRST:0|SECOND:0|THIRD:0|FOURTH:0|FIFTH:0=0",
            "FIRST:1|SECOND:1|THIRD:1|FOURTH:1|FIFTH:1=2031555000",
            "FIRST:1|SECOND:1|THIRD:1|FOURTH:2|FIFTH:1=2031605000",
    }, delimiter = '=')
    public void calculatePrizeMoney(String detail, int prize) {
        LottoResultDetail resultDetail = JUnitParser.parseLottoResultDetail(detail);
        PrizeMoney prizeMoney = new PrizeMoney(resultDetail);
        assertThat(prizeMoney.value()).isEqualTo(prize);
    }
}
