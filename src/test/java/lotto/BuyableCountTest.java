package lotto;

import lotto.domain.BuyableCount;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BuyableCountTest {
    @Test
    @DisplayName("가지고 있는 수가 인입된 수보다 크거나 같으면 false, 작으면 true 를 반환한다.")
    void isBigTest() {
        //Given
        BuyableCount buyableCount = new BuyableCount(2);
        
        //When
        boolean big = buyableCount.isSmall(1);
        boolean same = buyableCount.isSmall(2);
        boolean small = buyableCount.isSmall(3);
        
        //Then
        Assertions.assertThat(big).isFalse();
        Assertions.assertThat(same).isFalse();
        Assertions.assertThat(small).isTrue();
    }
}
