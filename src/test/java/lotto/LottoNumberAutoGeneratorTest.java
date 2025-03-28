package lotto;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoNumberAutoGeneratorTest {

    @Test
    void generate() {
        List<Integer> result = LottoNumberAutoGenerator.generateNumbers();
        assertThat(result.size()).isEqualTo(6);
    }
}
