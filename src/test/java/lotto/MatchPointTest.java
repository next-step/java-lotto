package lotto;

import lotto.domain.MatchPoint;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class MatchPointTest {
    @DisplayName("MatchPoint 같은 value 찾기")
    @ParameterizedTest
    @CsvSource(value = {"3, 5000, 1", "4, 50000, 0", "5, 1500000, 0", "4, 30000000, 1", "6, 2000000000, 1", "0, 0, 0"})
    void findMatchPoint(int matchPont, int amt, int bonus) {
        assertThat(MatchPoint.findMatchPoint(matchPont, bonus).getWinningAmt()).isEqualTo(amt);
    }
}
