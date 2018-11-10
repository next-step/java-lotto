package game.lotto.model;

import org.junit.Test;

import java.util.List;
import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosFactoryTest {

    @Test
    public void 로또_여러개_만들기() {
        final Amount amount = new Amount(new Money(10000));

        List<Lotto> lottos = LottosFactory.createLottos(amount);

        assertThat(lottos).hasSize(amount.getValue());
        assertThat(lottos).allMatch(Objects::nonNull);
    }

}