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
    @CsvSource(value = {"3, 5000", "4, 50000", "5, 1500000", "6, 2000000000", "0, 0"})
    void findMatchPoint(int matchPont, int amt) {
        assertThat(MatchPoint.findMatchPoint(matchPont).getWinningAmt()).isEqualTo(amt);
    }
}
