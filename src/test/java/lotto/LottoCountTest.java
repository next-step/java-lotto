package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.LottoCount;
import lotto.domain.PurchaseAmount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LottoCountTest {
    @DisplayName("구매금액에 해당하는 로또 갯수를 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"1000, 1", "11000, 11"})
    void fromPurchaseAmount(int putchaseAmout, int expected) {
        // given
        LottoCount lottoCount = LottoCount.fromPurchaseAmount(new PurchaseAmount(putchaseAmout));

        // when & then
        assertThat(lottoCount.getLottoCount()).isEqualTo(expected);
    }

    @Test
    void isCountGreaterThan() {
        LottoCount lottoCount = LottoCount.from(2);
        assertThat(lottoCount.isCountGreaterThan(1)).isTrue();
        assertThat(lottoCount.isCountGreaterThan(2)).isFalse();
        assertThat(lottoCount.isCountGreaterThan(3)).isFalse();
    }

    @Test
    void isCountGreaterOrEqualTo() {
        LottoCount lottoCount = LottoCount.from(2);
        assertThat(lottoCount.isCountGreaterOrEqualTo(1)).isTrue();
        assertThat(lottoCount.isCountGreaterOrEqualTo(2)).isTrue();
        assertThat(lottoCount.isCountGreaterOrEqualTo(3)).isFalse();
    }

    @Test
    void calculateDifference() {
        LottoCount lottoCount = LottoCount.from(3);
        assertThat(lottoCount.calculateDifference(2)).isEqualTo(1);
        assertThat(lottoCount.calculateDifference(1)).isEqualTo(2);
    }
}
