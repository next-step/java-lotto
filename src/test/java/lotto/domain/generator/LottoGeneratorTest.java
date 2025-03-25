package lotto.domain.generator;

import lotto.domain.Lotto;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoGeneratorTest {

    @ParameterizedTest
    @ValueSource(ints = {1000, 5000, 10000})
    public void 입력한_금액만큼_로또를_구매한다(int amount) {
        List<Lotto> lottos = LottoGenerator.purchaseLottos(amount);

        int expected = LottoGenerator.calculateLottosCount(amount);
        assertThat(lottos.size()).isEqualTo(expected);
    }

}
