package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class WinningSheetTest {

    @DisplayName("일치 횟수와 맞는 당첨을 찾는다.")
    @Test
    void findByMatchCount() {
        int matchCount = 4;
        WinningSheet findSheet = WinningSheet.findByMatchCount(matchCount);
        assertThat(findSheet).isEqualTo(WinningSheet.THIRD);
    }

    @DisplayName("일치 횟수가 0 이거나 당첨 횟수가 아니면 FAIL 반환")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2})
    void findByMissMatchCount(int missMatchCount) {
        WinningSheet failSheet = WinningSheet.findByMatchCount(missMatchCount);
        assertThat(failSheet).isEqualTo(WinningSheet.FAIL);
    }
}