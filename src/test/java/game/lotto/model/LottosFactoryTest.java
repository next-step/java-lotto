package game.lotto.model;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosFactoryTest {

    @Test
    public void 랜덤_로또_여러개_만들기() {
        final int size = 5;

        Set<Lotto> lottos = LottosFactory.createRandomLottos(size);

        assertThat(lottos).hasSize(size);
        assertThat(lottos).allMatch(Objects::nonNull);
    }

    @Test
    public void 수동_로또_여러개_만들기() {
        final List<String> manualNumbers = new ArrayList<>();
        manualNumbers.add("1, 2, 3, 4, 5, 6");
        manualNumbers.add("2, 3, 4, 5, 6, 7");

        Set<Lotto> lottos = LottosFactory.createManualLottos(manualNumbers);

        assertThat(lottos.size()).isEqualTo(manualNumbers.size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void 수동_로또_여러개_만들기_중복있을때() {
        final List<String> manualNumbers = new ArrayList<>();
        manualNumbers.add("1, 2, 3, 4, 5, 6");
        manualNumbers.add("2, 3, 4, 5, 6, 7");
        manualNumbers.add("2, 3, 4, 5, 6, 7");

        LottosFactory.createManualLottos(manualNumbers);
    }

    @Test
    public void 수동_자동_한번에_만들기() {
        final List<String> manualNumbers = new ArrayList<>();
        manualNumbers.add("1, 2, 3, 4, 5, 6");
        manualNumbers.add("2, 3, 4, 5, 6, 7");
        final Amount amount = new Amount(new Money(10000), manualNumbers.size());

        Set<Lotto> complexLottos = LottosFactory.createComplexLottos(amount, manualNumbers);

        assertThat(complexLottos).hasSize(amount.getAutoCount() + manualNumbers.size());
    }

}