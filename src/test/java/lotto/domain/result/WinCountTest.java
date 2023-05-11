package lotto.domain.result;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class WinCountTest {

    @Test
    @DisplayName(value = "카운트 plusOne 검사")
    void test1() {
        WinCount winCount = new WinCount(4);
        winCount.plusOne();
        assertThat(winCount).isEqualTo(new WinCount(5));

    }
}
