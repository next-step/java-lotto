package lotto.domain;

import lotto.domain.generator.StubLottoGenerator;
import lotto.domain.generator.StubLottosGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

class StatisticsTest {

    private WonNumbers wonNumbers = new WonNumbers("1, 2, 3, 4, 5, 6", "7");
    private List<Lotto> stubLottos = Arrays.asList(
            new Lotto(new StubLottoGenerator(Arrays.asList(8, 21, 23, 41, 42, 43))),
            new Lotto(new StubLottoGenerator(Arrays.asList(3, 5, 11, 16, 32, 38))),
            new Lotto(new StubLottoGenerator(Arrays.asList(7, 11, 16, 35, 36, 44))),
            new Lotto(new StubLottoGenerator(Arrays.asList(1, 8, 11, 31, 41, 42))),
            new Lotto(new StubLottoGenerator(Arrays.asList(13, 14, 16, 38, 42, 45))),
            new Lotto(new StubLottoGenerator(Arrays.asList(7, 11, 30, 40, 42, 43))),
            new Lotto(new StubLottoGenerator(Arrays.asList(2, 13, 22, 32, 38, 45))),
            new Lotto(new StubLottoGenerator(Arrays.asList(23, 25, 33, 36, 39, 41))),
            new Lotto(new StubLottoGenerator(Arrays.asList(1, 3, 5, 14, 22, 45))),
            new Lotto(new StubLottoGenerator(Arrays.asList(5, 9, 38, 41, 43, 44))),
            new Lotto(new StubLottoGenerator(Arrays.asList(2, 8, 9, 18, 19, 21))),
            new Lotto(new StubLottoGenerator(Arrays.asList(13, 14, 18, 21, 23, 35))),
            new Lotto(new StubLottoGenerator(Arrays.asList(17, 21, 29, 37, 42, 45))),
            new Lotto(new StubLottoGenerator(Arrays.asList(3, 8, 27, 30, 35, 44)))
    );
    private Lottos lottos = new Lottos(new StubLottosGenerator(stubLottos), new PurchaseAmount(stubLottos.size() * PurchaseAmount.AMOUNT_PER_LOTTO), Collections.emptyList());

    private Statistics statistics = new Statistics(wonNumbers, lottos);

    @Test
    @DisplayName("총 당청금 확인")
    void getWinAmount() {

        assertThat(statistics.getWinAmount()).isEqualTo(5000);
    }

    @Test
    @DisplayName("수익률 계산")
    void getEarnRate() {

        assertThat(statistics.getEarnRate()).isEqualTo(0.35);
    }

    @Test
    @DisplayName("이득/손해 판단")
    void isGain() {

        assertThat(statistics.isGain()).isFalse();
    }
}