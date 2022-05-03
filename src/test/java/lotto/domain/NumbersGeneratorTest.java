package lotto.domain;

import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class NumbersGeneratorTest {
    @ParameterizedTest
    @ValueSource(strings = {"1", "3", "8"})
    void 생성_테스트(int length) {
        List<Integer> a = NumbersGenerator.generate(length);
        assertThat(NumbersGenerator.generate(length).size()).isEqualTo(length);
    }
}
