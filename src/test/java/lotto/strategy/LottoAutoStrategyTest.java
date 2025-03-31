package lotto.strategy;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import lotto.domain.Lotto;

import static org.assertj.core.api.Assertions.assertThat;

class LottoAutoStrategyTest {
    private static final int VALID_START = 1;
    private static final int VALID_END = 45;

    @RepeatedTest(100)
    @DisplayName("랜덤 전략으로 생성된 번호가 유효한지 검증")
    void generate_Lottos_ValidNumbers() {
        List<Lotto> lottos = new LottoAutoStrategy(5).generateLottos();

        for (Lotto lotto : lottos) {
            List<Integer> numbers = lotto.getLottoNumbers();

            assertThat(numbers)
                .hasSize(6)
                .doesNotHaveDuplicates()
                .allMatch(n -> n >= VALID_START && n <= VALID_END)
                .isSorted();
        }
    }
}
