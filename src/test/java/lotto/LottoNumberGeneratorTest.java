package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

class LottoNumberGeneratorTest {

    @Test
    void check_number_count() {
        assertThat(LottoNumberGenerator.sixNumberGenerator().size()).isEqualTo(6);
    }

    @Test
    void check_all_different() {
        Set<Integer> set = new HashSet<>(LottoNumberGenerator.sixNumberGenerator());
         assertThat(set.size()).isEqualTo(6);
    }
}
