package step3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class PrizeTest {

    // init
    @DisplayName("Prize 상금 체크")
    @ParameterizedTest
    @CsvSource(value = {
            "0:0:false",
            "1:0:false",
            "2:0:false",
            "3:5000:false",
            "4:50000:false",
            "5:1500000:false",
            "5:30000000:true",
            "6:2000000000:false"
    }, delimiter = ':'
    )
    public void Prize_상금_체크(int matchedNumber, int prizePrice, boolean bonusNumberMatching) {
        Prize prize = Prize.valueOf(matchedNumber, bonusNumberMatching);
        assertThat(prize.getPrizePrice()).isEqualTo(prizePrice);
    }

}
