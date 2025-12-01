package lotto.generator;

import lotto.domain.Lottos;
import lotto.domain.Money;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AutoLottoGeneratorTest {
    @Test
    void generate() {
        Money money = new Money(5_000);
        AutoLottoGenerator autoLottoGenerator = new AutoLottoGenerator(money);
        Lottos lottos = autoLottoGenerator.generate();
        assertThat(lottos.size()).isEqualTo(money.countOfBuyingLotto());
        System.out.println(lottos);
    }
}
