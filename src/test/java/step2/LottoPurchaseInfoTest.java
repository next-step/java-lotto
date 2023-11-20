package step2;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step2.lotto.domain.LottoPurchaseInfo;

public class LottoPurchaseInfoTest {

    @ParameterizedTest
    @CsvSource(value = {"0,0", "5500,5"}, delimiter = ',')
    @DisplayName("입력한 금액별로 로또의 발행 갯수를 정한다.")
    void lottoPurchaseInfo(int purchaseAmount, int expected) {
        assertThat(new LottoPurchaseInfo(purchaseAmount).getLottoPrice()).isEqualTo(expected);
    }

}
