package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertAll;

@DisplayName("구입한 모든 `Lotto`를 가진 `Lottos`에 대한 테스트")
class LottosTest {
    private List<Lotto> manualPurchasingLottos;

    @BeforeEach
    void init() {
        manualPurchasingLottos = Arrays.asList(generateLotto(), generateLotto(), generateLotto());
    }

    private Lotto generateLotto() {
        return new Lotto(new LottoNumbers());
    }

    @DisplayName("`Lottos` 생성")
    @Test
    void createLottosTest() {
        // When
        Lottos lottos = new Lottos(Lottos.MIN_LOTTO_SIZE, manualPurchasingLottos);
        // Then
        assertThat(lottos).isNotNull();
    }

    @DisplayName("빈 로또가 전달되었을 때 `Lottos` 생성 예외 확인")
    @Test
    void checkExceptionWithEmptyLottosTest() {
        // When & Then
        assertThatIllegalArgumentException().isThrownBy(
                () -> new Lottos(0, new ArrayList<>())
        );
    }

    @DisplayName("잘못된 사이즈로 자동 생성된 로또가 전달되었을 때 `Lottos` 생성 예외 확인")
    @Test
    void checkExceptionWithInvalidAutomatedLottoSizeTest() {
        // When & Then
        assertThatIllegalArgumentException().isThrownBy(
                () -> new Lottos(-1, manualPurchasingLottos)
        );
    }

    @DisplayName("수동으로 잘못 생성된 로또가 전달되었을 때 `Lottos` 생성 예외 확인")
    @ParameterizedTest
    @NullSource
    void checkExceptionWithInvalidManualLottosTest(ArrayList<Lotto> manualLottos) {
        // When & Then
        assertThatIllegalArgumentException().isThrownBy(
                () -> new Lottos(3, manualLottos)
        );
    }

    @DisplayName("`Lottos`의 통계 검색")
    @Test
    void retrieveStatisticsTest() {
        // Given
        Lottos lottos = new Lottos(10, manualPurchasingLottos);
        Lotto lotto = new Lotto();
        LottoNumber bonusNumber = new LottoNumber(provideBonusNumber(lotto));
        WinningLotto winningLotto = new WinningLotto(lotto, bonusNumber);
        // When
        LottoResult lottoResult = lottos.retrieveStatistics(winningLotto);
        // Then
        assertAll(
                () -> assertThat(lottoResult).isNotNull(),
                () -> assertThat(lottoResult.getEarningsRatio()).isNotNegative(),
                () -> assertThat(lottoResult.getStatistics()).isNotNull()
        );
    }

    private int provideBonusNumber(Lotto winningLotto) {
        return IntStream.rangeClosed(LottoNumber.MIN_NUMBER, LottoNumber.MAX_NUMBER)
                .filter(number -> !winningLotto.getLottoNumbers().contains(number))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("잘못된 갯수의 숫자로 구성된 당첨 로또입니다."));
    }
}
