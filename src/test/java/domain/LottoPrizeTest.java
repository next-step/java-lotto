package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static domain.LottoPrize.PRIZE_MAP;

class LottoPrizeTest {

    @ParameterizedTest
    @CsvSource(value = {"3:5000", "4:50000", "5:1500000", "6:2000000000"}, delimiter = ':')
    @DisplayName("일치한 숫자에 해당하는 상금을 얻는다.")
    void 일치한_수에_해당하는_상금을_준다(int matchedNumber, int prize) {
        Assertions.assertThat(PRIZE_MAP.get(matchedNumber)).isEqualTo(prize);
    }
}