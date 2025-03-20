package lotto.model.generator;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class LottoGeneratorTest {
    @Test
    void 로또_번호_생성() {
        NumberGenerator testGenerator = new NumberGeneratorTestImpl();
        LottoGenerator lottoGenerator = new LottoGenerator(testGenerator);

        List<Integer> numbers = lottoGenerator.generate();

        assertThat(numbers).hasSize(6);
        assertThat(numbers.get(0)).isEqualTo(1);
    }

}
