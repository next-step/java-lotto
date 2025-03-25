package lotto;

import lotto.domain.Lottos;
import lotto.domain.generator.LottoGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoGeneratorTest {

    @ParameterizedTest
    @ValueSource(ints = {1000, 5000, 10000})
    public void 입력한_금액만큼_로또를_구매한다(int amount) {
        Lottos lottos = LottoGenerator.generateLottosByAmount(amount);

        int expected = LottoGenerator.calculateLottosCount(amount);
        assertThat(lottos.size()).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(ints = {1234, 5100, 11110})
    public void 거스름_돈이_생기는_구입금액인_경우_예외가_발생한다(int amount) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LottoGenerator.generateLottosByAmount(amount));
    }

}
