package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoStoreTest {
    private ManualLotto manualLotto;

    @BeforeEach
    void setUp() {
        manualLotto = ManualLotto.of(Collections.singletonList("1, 2, 3, 4, 5, 6"));
    }

    @DisplayName("로또 1미만의 수 예외처리 테스트")
    @ParameterizedTest
    @ValueSource(ints = {200, -500, 900})
    void notValidIssueCountTest(int price) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LottoStore.of(Money.of(price), manualLotto));
    }

    @DisplayName("입력한 금액에 따른 로또 갯수 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1000, 10000, 13500, 30000})
    void divideMoneyToLottoPriceTest(int price) {
        assertThat(LottoStore.of(Money.of(price), manualLotto).calculateCount(price))
                .isEqualTo((price / LottoStore.LOTTO_PRICE) - manualLotto.size());
    }

    @DisplayName("로또 발급 테스트")
    @ParameterizedTest
    @ValueSource(ints = {10000, 15200, 20000})
    void issueLottoTest(int price) {
        LottoStore lottoStore = LottoStore.of(Money.of(price), manualLotto);
        assertThat(lottoStore.issue().getLottos())
                .hasSize(lottoStore.calculateCount(price) + manualLotto.size());
    }

    @DisplayName("당첨 확인 테스트")
    @Test
    void findWinningLottoTest() {
        final Lotto lotto = Lotto.of(Arrays.asList(7, 9, 11, 18, 24, 39));
        final WinningLotto winningLotto = WinningLotto.of("7, 9, 11, 18, 24, 39", 15);

        assertThat(winningLotto.match(lotto)).isEqualTo(Ranking.FIRST);
    }

    @DisplayName("2등 당첨 확인 테스트")
    @Test
    void findWinningLottoSecondTest() {
        final Lotto lotto = Lotto.of(Arrays.asList(7, 9, 11, 18, 24, 39));
        final WinningLotto winningLotto = WinningLotto.of("7, 9, 11, 18, 24, 40", 39);

        assertThat(winningLotto.match(lotto)).isEqualTo(Ranking.SECOND);
    }
}