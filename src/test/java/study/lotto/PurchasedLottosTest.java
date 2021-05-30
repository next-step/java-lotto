package study.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import study.lotto.domain.PurchasedLottos;

import static org.assertj.core.api.Assertions.assertThat;

public class PurchasedLottosTest {

    @DisplayName("구매 장수 만큼 생성되었는지 확인")
    @ParameterizedTest
    @CsvSource({"14,14", "2,2", "1,1", "4,4"})
    public void lottoPapersTest(int purchaseCount, int expect) {
        PurchasedLottos purchasedLottos = new PurchasedLottos(purchaseCount);
        assertThat(purchasedLottos.count()).isEqualTo(expect);
    }

}