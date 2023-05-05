package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class PrizeMoneyTest {

    @DisplayName("숫자 일치 갯수별 당첨 상금을 확인한다.")
    @ParameterizedTest
    @CsvSource(value = {"6:2000000000", "5:1500000", "4:50000", "3:5000", "2:0", "1:0"}, delimiter = ':')
    public void 당첨금_확인(int rank, long prizeMoney) throws Exception {
        assertThat(PrizeMoney.toPrizeMoney(rank)).isEqualTo(prizeMoney);
    }

}

