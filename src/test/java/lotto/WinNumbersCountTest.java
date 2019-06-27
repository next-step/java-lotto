package lotto;

import lotto.domain.WinNumbersCount;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinNumbersCountTest {
    @Test
    @DisplayName("일치하는 갯수의 count 가 증가한다.")
    void plusCountTest() {
        //Given
        int matchCount = 3;
        
        //When
        WinNumbersCount winNumbersCount = new WinNumbersCount();
        
        //Then
        Assertions.assertThat(winNumbersCount.addWinCount(matchCount)).isEqualTo(1);
    }
    
    @Test
    @DisplayName("당첨된 로또의 합산을 구한다.")
    void getTotalPrizeTest() {
        //Given
        WinNumbersCount winNumbersCount = new WinNumbersCount();
        winNumbersCount.addWinCount(3);
        winNumbersCount.addWinCount(3);
        
        //When
        long totalPrize = winNumbersCount.getTotalPrizeMoney();
        
        //Then
        Assertions.assertThat(totalPrize).isEqualTo(10000);
    }
    
}
