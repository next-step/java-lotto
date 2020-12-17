package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertAll;

@DisplayName("구입한 모든 `Lotto`를 가진 `Lottos`에 대한 테스트")
class LottosTest {
    private static final int MIN_LOTTO_SIZE = Lottos.MIN_LOTTO_SIZE;
    private static final int INVALID_LOTTO_SIZE = Lottos.MIN_LOTTO_SIZE - 1;
    private static final int TEST_LOTTO_SIZE = 10;

    @DisplayName("`Lottos` 생성")
    @Test
    void createLottoGroupTest() {
        // When
        Lottos lottos = new Lottos(MIN_LOTTO_SIZE);
        // Then
        assertThat(lottos).isNotNull();
    }

    @DisplayName("잘못된 사이즈로 생성되는 `Lottos`의 예외 확인")
    @Test
    void checkExceptionWithInvalidLottoSizeTest() {
        // When & Then
        assertThatIllegalArgumentException().isThrownBy(
                () -> new Lottos(INVALID_LOTTO_SIZE)
        );
    }

    @DisplayName("`Lottos`의 통계 검색")
    @Test
    void retrieveStatisticsTest() {
        // Given
        Lotto winningLottoNumbers = new Lotto();
        Lottos lottos = new Lottos(TEST_LOTTO_SIZE);
        // When
        LottoResult lottoResult = lottos.retrieveStatistics(winningLottoNumbers);
        // Then
        assertAll(
                () -> assertThat(lottoResult).isNotNull(),
                () -> assertThat(lottoResult.getEarningsRatio()).isNotNegative(),
                () -> assertThat(lottoResult.getStatistics()).isNotNull()
        );
    }
}
