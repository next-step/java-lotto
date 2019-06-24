package lotto;

import lotto.common.ErrorMessage;
import lotto.domain.LottoNumbers;
import lotto.domain.LottoNumber;
import lotto.domain.Lottos;
import lotto.domain.OwnPrize;
import lotto.domain.WinLottoNumbers;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
