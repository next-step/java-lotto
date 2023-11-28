package step2;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.List;
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
        List<String> manualNumbers = List.of("1,2,3,4,5,6");
        assertThat(new LottoPurchase(purchaseAmount, manualNumbers).getLottoTicketCount()
            .getTotalLottoTicketCount()).isEqualTo(expected);
    }

    @Test
    @DisplayName("로또 구입 최소금액은 1000원 이다.")
    void lottoPurchaseInputMoneyValidateTest() {
        List<String> manualNumbers = List.of("1,2,3,4,5,6", "11,12,13,14,15,16");
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoPurchase(999, manualNumbers));
    }

}
