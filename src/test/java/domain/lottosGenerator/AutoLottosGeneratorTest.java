package domain.lottosGenerator;

import domain.Lotto;
import domain.Money;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class AutoLottosGeneratorTest {

    private LottosGenerator generator;

    @Before
    public void setUp() throws Exception {
        generator = new AutoLottosGenerator();
    }

    @Test
    public void 구입_금액에_맞는_갯수의_자동_로또를_반환한다() {
        List<Lotto> games = generator.generate(new Money(14500));

        assertThat(games).hasSize(14);
    }

}