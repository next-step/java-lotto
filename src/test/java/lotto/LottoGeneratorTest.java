package lotto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoGeneratorTest {

    @Test
    public void generateLottoTest() {
        Lotto lotto = LottoGenerator.generateAutoLotto();

        assertThat(lotto).isInstanceOf(Lotto.class);
    }
}
