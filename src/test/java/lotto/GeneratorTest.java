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
            assertThat(i).isGreaterThanOrEqualTo(1).isLessThanOrEqualTo(45);
        }
    }

    @Test
    void 로또_정렬() {
        Generator generator = new Generator();
        List<Integer> result = generator.run();
        for (int i = 0; i < result.size() - 1; i++) {
            assertThat(result.get(i)).isLessThan(result.get(i + 1));
        }
    }
}
