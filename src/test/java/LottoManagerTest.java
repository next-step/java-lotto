import domain.LottoManager;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoManagerTest {


    @ParameterizedTest
    @CsvSource(value = {"14000,14", "6500,6"})
    public void getPurchaseLottoCount(int purchaseAmount, int result) {
        LottoManager.getPurchaseLottoCount(purchaseAmount);
        assertThat(LottoManager.getPurchaseLottoCount(purchaseAmount)).isEqualTo(result);
    }
}
