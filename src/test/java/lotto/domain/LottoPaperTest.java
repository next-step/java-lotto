package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoPaperTest {
    @DisplayName("예산으로 살 수 있는 로또 개수 테스트")
    @Test
    public void possibleTotalLottoCount() {
        Assertions.assertThat(new LottoPaper(1000).possibleTotalLottoCount())
                .isEqualTo(1);

        Assertions.assertThat(new LottoPaper(1500).possibleTotalLottoCount())
                .isEqualTo(1);

        Assertions.assertThat(new LottoPaper(10000).possibleTotalLottoCount())
                .isEqualTo(10);
    }
}