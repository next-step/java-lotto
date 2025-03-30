package lotto.strategy;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import static org.assertj.core.api.Assertions.assertThat;

class LottoAutoStrategyTest {
    private static final int VALID_START = 1;
    private static final int VALID_END = 45;
    private final LottoAutoStrategy strategy = new LottoAutoStrategy();

    @RepeatedTest(100)
    @DisplayName("랜덤 전략으로 생성된 번호가 유효한지 검증")
    void generate_ValidNumbers() {
        List<Integer> numbers = strategy.generate();

        assertThat(numbers)
            .hasSize(6)
            .doesNotHaveDuplicates()
            .allMatch(n -> n >= VALID_START && n <= VALID_END)
            .isSorted();
    }
}
