package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GeneratorTest {
    @Test
    void 로또_자동_생성() {
        Generator generator = new Generator();
        Lotto lotto = generator.run();
        assertThat(lotto.hasSize(6)).isTrue();
        assertThat(lotto.isValidRangeNumbers()).isTrue();
    }

    @Test
    void 로또_정렬() {
        Generator generator = new Generator();
        Lotto lotto = generator.run();
        assertThat(lotto.isSorted()).isTrue();
    }
}
