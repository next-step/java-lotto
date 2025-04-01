package lotto.strategy;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import lotto.domain.Lotto;
import lotto.domain.LottoNo;

import static org.assertj.core.api.Assertions.assertThat;

class LottoAutoStrategyTest {
    @RepeatedTest(100)
    @DisplayName("랜덤 전략으로 생성된 번호가 유효한지 검증")
    void generate_Lottos_ValidNumbers() {
        List<Lotto> lottos = new LottoAutoStrategy(5).generateLottos();

        for (Lotto lotto : lottos) {
            List<LottoNo> numbers = lotto.getLottoNumbers();

            assertThat(numbers)
                .hasSize(6)
                .doesNotHaveDuplicates()
                .isSorted();
        }
    }
}
