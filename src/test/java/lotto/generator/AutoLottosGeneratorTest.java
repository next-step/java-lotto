package lotto.generator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.generator.AutoLottosGenerator;
import lotto.domain.generator.LottosGenerator;

public class AutoLottosGeneratorTest {

    @ParameterizedTest(name = "로또 번호 생성 테스트")
    @CsvSource(value={"1000:1", "5000:5", "10000:10"}, delimiter = ':')
    void generate(int inputs, int expect) {
        LottosGenerator generator = new AutoLottosGenerator();
        Lottos lottos = generator.generate(new Money(inputs));
        assertThat(lottos.lottos().size()).isEqualTo(expect);
    }
}
