package lotto.domain;

import lotto.domain.generator.StubLottoGenerator;
import lotto.domain.generator.StubLottosGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottosTest {

    @ParameterizedTest(name = "지난주 우승번호와 일차하는 개수 확인. 일치개수={0}")
    @ValueSource(ints = {3, 4, 5, 6})
    void getWonNumbersCorrectCount(int correctCount) {

        List<Lotto> stubLottos = Arrays.asList(
                new Lotto(new StubLottoGenerator(Arrays.asList(1, 2, 3, 11, 12, 13))),
                new Lotto(new StubLottoGenerator(Arrays.asList(1, 2, 3, 4, 12, 13))),
                new Lotto(new StubLottoGenerator(Arrays.asList(1, 2, 3, 4, 5, 13))),
                new Lotto(new StubLottoGenerator(Arrays.asList(1, 2, 3, 4, 5, 6))));

        Lottos lottos = new Lottos(new StubLottosGenerator(stubLottos), new PurchaseAmount(stubLottos.size() * PurchaseAmount.AMOUNT_PER_LOTTO));

        WonNumbers wonNumbers = new WonNumbers("1, 2, 3, 4, 5, 6");
        assertThat(lottos.getWonNumbersCorrectCount(correctCount, wonNumbers)).isEqualTo(1);
    }
}