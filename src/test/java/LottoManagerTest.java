import domain.LottoManager;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoManagerTest {


    @ParameterizedTest
    @CsvSource(value = {"14000,14", "6500,6"})
    public void 로또구매가격으로_구입개수만들기_테스트(int purchaseAmount, int result) {
        LottoManager lottoManager = new LottoManager(purchaseAmount);
        assertThat(lottoManager.getPurchaseLottoCount()).isEqualTo(result);
    }

}
