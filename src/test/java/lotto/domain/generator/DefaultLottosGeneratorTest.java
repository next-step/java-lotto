package lotto.domain.generator;

import lotto.domain.Lotto;
import lotto.domain.Money;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class DefaultLottosGeneratorTest {
    @Test
    public void 로또_생성() {
        String manualLottos = "1,2,3,4,5,6\n1,2,3,4,5,7";
        DefaultLottosGenerator lottoGenerator = new DefaultLottosGenerator(manualLottos);
        List<Lotto> lottos = lottoGenerator.generate(new Money(5_000));
        assertThat(lottos).hasSize(5);
    }
}
