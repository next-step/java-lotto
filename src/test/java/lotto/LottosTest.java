package lotto;

import lotto.domain.CashPayments;
import lotto.domain.LottoNumbers;
import lotto.domain.Lottos;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class LottosTest {
    @Test
    @DisplayName("구매할 수 있는 횟수를 구한다.")
    void getBuyableCount() {
        //Given
        CashPayments cashPayment = new CashPayments(5000);
        //When
        int buyableCount = Lottos.getBuyableCount(cashPayment);
        //Then
        Assertions.assertThat(buyableCount).isEqualTo(5);
    }
    
    @Test
    @DisplayName("목록에 있는 로또번호 셋이라면 true 를 반환한다.")
    void test() {
        //Given
        String hasNumbers = "1,2,3,4,5,6";
        String notHasNumbers = "4,5,6,7,8,9";
        Lottos lottos = new Lottos(Arrays.asList(
            new LottoNumbers(hasNumbers),
            new LottoNumbers("2,3,4,5,6,7"))
        );
        LottoNumbers lottoNumbers = new LottoNumbers(hasNumbers);
        LottoNumbers notHasLottoNumbers = new LottoNumbers(notHasNumbers);
        //When
        boolean hasLottos = lottos.hasLottoNumbers(lottoNumbers);
        boolean notHasLottos = lottos.hasLottoNumbers(notHasLottoNumbers);
        //Then
        Assertions.assertThat(hasLottos).isTrue();
        Assertions.assertThat(notHasLottos).isFalse();
    }
}
