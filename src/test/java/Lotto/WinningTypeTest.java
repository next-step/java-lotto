package Lotto;

import Lotto.domain.WinningType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningTypeTest {
    @ParameterizedTest
    @CsvSource(value = {
            "1:false:MISS",
            "3:false:FIFTH",
            "4:false:FOURTH",
            "5:false:THIRD",
            "5:true:SECOND",
            "6:false:FIRST"
    }, delimiter = ':')
    @DisplayName("등수별 테스트")
    void getWinningTypeWithCountOfMatch(final int countOfMatch,
                                        final boolean hasBonusNumber,
                                        final WinningType result) {
        assertThat(WinningType.valueOf(countOfMatch, hasBonusNumber)).isEqualTo(result);
    }
}
