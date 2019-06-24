package lotto;

import lotto.domain.WinNumbersCount;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinNumbersCountTest {
    @Test
    @DisplayName("일치하는 갯수의 count 가 증가한다.")
    void test() {
        //Given
        int matchCount = 3;
        //When
        WinNumbersCount winNumbersCount = new WinNumbersCount();
        //Then
        Assertions.assertThat(winNumbersCount.addWinCount(matchCount)).isEqualTo(1);
    }
}
