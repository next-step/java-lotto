package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class AutoLottosGeneratorTest {
    @ParameterizedTest
    @DisplayName("자동 로또 생성기는 Money 값에 따라서 로또를 생성한다.")
    @ValueSource(ints = {0, 10})
    void generate(int count) {
        assertThat(new AutoLottosGenerator(new Count(count)).generate().size()).isEqualTo(count);
    }
}