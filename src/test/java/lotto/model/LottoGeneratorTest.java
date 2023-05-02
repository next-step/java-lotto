package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoGeneratorTest {

    private final LottoGenerator generator = new LottoGenerator();

    @ParameterizedTest
    @DisplayName("로또를 정확한 개수로 발급한다")
    @ValueSource(ints = {1, 5})
    public void count(int input) {
        Count count = new Count(input);

        Lottos lottos = generator.generate(count);

        assertThat(lottos).hasSize(input);
    }

    @ParameterizedTest
    @NullSource
    @DisplayName("Count가 `null`이면 예외 발생")
    public void nullException(Count count) {
        assertThatThrownBy(() -> {
            generator.generate(count);
        });
    }
}