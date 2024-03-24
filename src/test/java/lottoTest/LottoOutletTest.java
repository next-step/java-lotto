package lottoTest;

import lotto.LottoOutlet;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LottoOutletTest {
    @ParameterizedTest(name = "{0} 가격으로 구매가능한 로또 장수는 {1}")
    @CsvSource(value = {"14000:14", "1000:1", "0:0", "750:0", "1500:1"}, delimiter = ':')
    void moneyToLottoCount(int money, int expectedLottoCount) {
        Assertions.assertThat(LottoOutlet.lottoCount(money)).isEqualTo(expectedLottoCount);
    }
}
