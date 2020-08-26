package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoStoreTest {
    private LottoCount lottoCount;
    private ManualLottoGenerator manualLottoGenerator;

    @BeforeEach
    void setUp() {
        lottoCount = LottoCount.of(3);
        List<Integer> firstManualLotto = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> secondManualLotto = Arrays.asList(7, 8, 9, 10, 11, 12);
        List<Integer> thirdManualLotto = Arrays.asList(13, 14, 15, 16, 17, 18);
        manualLottoGenerator = ManualLottoGenerator.of(Arrays.asList(firstManualLotto,
                secondManualLotto, thirdManualLotto));
    }

    @DisplayName("로또 발급 테스트")
    @ParameterizedTest
    @ValueSource(ints = {10000, 15200, 20000})
    void issueLottoTest(int price) {
        LottoStore lottoStore = LottoStore.of(Money.of(price), lottoCount);
        assertThat(lottoStore.issueLotto(manualLottoGenerator).getLottos())
                .hasSize(lottoCount.calculateCount(price) + lottoCount.getCount());
    }

    @DisplayName("당첨 확인 테스트")
    @Test
    void findWinningLottoTest() {
        final Lotto lotto = Lotto.of(Arrays.asList(7, 9, 11, 18, 24, 39));
        final WinningLotto winningLotto = WinningLotto.of(Arrays.asList(7, 9, 11, 18, 24, 39), 15);

        assertThat(winningLotto.match(lotto)).isEqualTo(Ranking.FIRST);
    }

    @DisplayName("2등 당첨 확인 테스트")
    @Test
    void findWinningLottoSecondTest() {
        final Lotto lotto = Lotto.of(Arrays.asList(7, 9, 11, 18, 24, 39));
        final WinningLotto winningLotto = WinningLotto.of(Arrays.asList(7, 9, 11, 18, 24, 40), 39);

        assertThat(winningLotto.match(lotto)).isEqualTo(Ranking.SECOND);
    }
}