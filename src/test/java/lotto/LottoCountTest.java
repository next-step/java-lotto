package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.LottoCount;
import lotto.domain.PurchaseAmount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LottoCountTest {
    @DisplayName("구매금액에 해당하는 로또 갯수를 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"1000, 1", "11000, 11"})
    void getLottoCount(int putchaseAmout, int expected) {
        LottoCount lottoCount = LottoCount.from(PurchaseAmount.from(putchaseAmout));
        assertThat(lottoCount.getLottoCount()).isEqualTo(expected);
    }
}
