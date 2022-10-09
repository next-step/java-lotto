package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoPrizeTest {

    @ParameterizedTest
    @DisplayName("로또 매칭 갯수별 상금 조회")
    @CsvSource(
            delimiter = ':',
            value = {"0:0", "1:0", "2:0", "3:5000", "4:50000", "5:1500000", "6:2000000000"}
    )
    void selectPrize(int matchedNumber, int prizeMoney) {
        assertThat(LottoPrize.from(matchedNumber).amount()).isEqualTo(prizeMoney);
    }
}
