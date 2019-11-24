package step4.generator;

import org.junit.jupiter.api.Test;
import step4.model.Lotto;
import step4.model.Money;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class AutoLottoGeneratorTest {
    @Test
    void 로또생성() {
        List<Lotto> lottos = new AutoLottoGenerator().generate(new Money(10000));
        assertThat(lottos).hasSize(10);
    }
}
