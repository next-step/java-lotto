package game.lotto.model;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ComplexLottosGeneratorTest {

    @Test
    public void 수동_자동_한번에_만들기() {
        final List<String> manualNumbers = new ArrayList<>();
        manualNumbers.add("1, 2, 3, 4, 5, 6");
        manualNumbers.add("2, 3, 4, 5, 6, 7");
        final Amount amount = new Amount(new Money(10000), manualNumbers.size());

        LottosGenerator generator = new ComplexLottosGenerator(new AutoLottosGenerator(amount), new ManulLottosGenerator(manualNumbers));

        List<Lotto> complexLottos = generator.generate();

        assertThat(complexLottos).hasSize(amount.getAutoCount() + manualNumbers.size());
    }

}