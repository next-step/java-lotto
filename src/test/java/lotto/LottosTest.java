package lotto;

import lotto.domain.Lottos;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottosTest {
    private Lottos lottos;
    
    @BeforeEach
    void setUp() { 
        lottos = new Lottos();
    }
    
    @Test
    @DisplayName("구매할 수 있는 횟수를 구한다.")
    void getBuyableCount() {
        //Given
        int cashPayment = 5000;
        //When
        int buyableCount = Lottos.getBuyableCount(cashPayment);
        //Then
        Assertions.assertThat(buyableCount).isEqualTo(5);
    }
}
