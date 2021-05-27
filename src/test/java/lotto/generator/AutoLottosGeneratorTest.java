package lotto.generator;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import lotto.domain.Lotto;
import lotto.domain.LottoTicketCount;
import lotto.domain.Money;
import lotto.domain.generator.AutoLottosGenerator;
import lotto.domain.generator.LottosGenerator;

public class AutoLottosGeneratorTest {

    @ParameterizedTest(name = "로또 번호 생성 테스트 - 금액 기준")
    @CsvSource(value={"1000:1", "5000:5", "10000:10"}, delimiter = ':')
    void generateByMoney(int inputs, int expect) {
        LottosGenerator generator = new AutoLottosGenerator();
        List<Lotto> lottos = generator.generate(new Money(inputs));
        assertThat(lottos.size()).isEqualTo(expect);
    }

    @ParameterizedTest(name = "로또 번호 생성 테스트 - 카운트 기준")
    @CsvSource(value={"1:1000", "5:5000", "10:10000"}, delimiter = ':')
    void generateByCount(int inputs, int expect) {
        LottosGenerator generator = new AutoLottosGenerator();
        List<Lotto> lottos = generator.generate(new LottoTicketCount(inputs));
        List<Lotto> lottos2 = generator.generate(new Money(expect));
        assertThat(lottos.size()).isEqualTo(lottos2.size());
    }
}
