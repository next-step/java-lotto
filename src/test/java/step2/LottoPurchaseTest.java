package step2;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step2.lotto.domain.LottoPurchase;

public class LottoPurchaseTest {

    @ParameterizedTest
    @CsvSource(value = {"1000,1", "5500,5"}, delimiter = ',')
    @DisplayName("입력한 금액별로 로또의 발행 갯수를 정한다.")
    void lottoPurchaseInfo(int purchaseAmount, int expected) {
        assertThat(new LottoPurchase(purchaseAmount).getLottoTicketCount()).isEqualTo(expected);
    }

    @Test
    @DisplayName("로또 구입 최소금액은 1000원 이다.")
    void lottoPurchaseInputMoneyValidateTest() {
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoPurchase(999));
    }

}
