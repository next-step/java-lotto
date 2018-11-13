package game.lotto.model;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ManulLottosGeneratorTest {

    @Test
    public void 수동_로또_여러개_만들기() {
        final List<String> manualNumbers = new ArrayList<>();
        manualNumbers.add("1, 2, 3, 4, 5, 6");
        manualNumbers.add("2, 3, 4, 5, 6, 7");

        LottosGenerator generator = new ManulLottosGenerator(manualNumbers);

        List<Lotto> lottos = generator.generate();

        assertThat(lottos.size()).isEqualTo(manualNumbers.size());
    }

}