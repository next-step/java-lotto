package lotto;

import lotto.domain.Lotto;
import lotto.domain.generator.LottoGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoGeneratorTest {

    @ParameterizedTest
    @ValueSource(ints = {1000, 5000, 10000})
    public void 입력한_금액만큼_로또를_구매한다(int amount) {
        List<Lotto> lottoList = LottoGenerator.generateLottoListByPurchaseAmount(amount);

        int expected = LottoGenerator.calculateLottoCount(amount);
        assertThat(lottoList.size()).isEqualTo(expected);
    }

}
