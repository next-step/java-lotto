package lotto;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GeneratorTest {
    @Test
    void 로또_자동_생성() {
        Generator generator = new Generator();
        List<Integer> result = generator.run();
        assertThat(result).hasSize(6);
        for (Integer i : result) {
            assertThat(i >= 1 && i <= 45).isTrue();
        }
    }
}
