package game.lotto.model;

import org.junit.Test;

import java.util.List;
import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;

public class AutoLottosGeneratorTest {

    @Test
    public void 랜덤_로또_여러개_만들기() {
        final int size = 5;

        LottosGenerator generator = new AutoLottosGenerator(new Amount(size, 0));

        List<Lotto> lottos = generator.generate();

        assertThat(lottos).hasSize(size);
        assertThat(lottos).allMatch(Objects::nonNull);
    }

}