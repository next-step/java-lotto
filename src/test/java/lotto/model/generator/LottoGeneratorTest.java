package lotto.model.generator;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Set;
import org.junit.jupiter.api.Test;

class LottoGeneratorTest {

    @Test
    void 로또_번호_생성() {
        NumberGenerator testGenerator = new NumberGeneratorTestImpl();
        LottoGenerator lottoGenerator = new LottoGenerator(testGenerator);

        Set<Integer> numbers = lottoGenerator.generate();

        assertThat(numbers).hasSize(6);
        assertThat(numbers).containsExactly(1, 2, 3, 4, 5, 6);
    }

}
