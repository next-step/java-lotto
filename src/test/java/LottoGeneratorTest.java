import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGeneratorTest {

    private final LottoGenerator lottoGenerator = new LottoGenerator(new RandomGenerator());

    @Test
    void gen_lotto(){
        Lotto newLotto = lottoGenerator.generate();

        assertThat(newLotto.numCount()).isEqualTo(6);
    }
}
