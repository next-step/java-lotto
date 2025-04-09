package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoPriceTest {
    @DisplayName("예산으로 살 수 있는 로또 개수 테스트")
    @Test
    public void possibleTotalLottoCount() {
        Assertions.assertThat(LottoPrice.possibleTotalLottoCount(1000))
                .isEqualTo(1);

        Assertions.assertThat(LottoPrice.possibleTotalLottoCount(1500))
                .isEqualTo(1);

        Assertions.assertThat(LottoPrice.possibleTotalLottoCount(10000))
                .isEqualTo(10);
    }
}