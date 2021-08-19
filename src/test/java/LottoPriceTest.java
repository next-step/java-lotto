import domain.LottoPrice;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("NonAsciiCharacters")
public class LottoPriceTest {

    @ParameterizedTest
    @CsvSource(value = {"1000,1", "7500,7"})
    public void 금액에따른_로또갯수가져오는_테스트(int purchaseAmount, int purchaseCount) {
        LottoPrice lottoPrice = new LottoPrice();
        assertThat(lottoPrice.purchaseLottoCount(purchaseAmount)).isEqualTo(purchaseCount);
    }
}
