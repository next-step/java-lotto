package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertAll;

@DisplayName("구입한 모든 `Lotto`를 가진 `Lottos`에 대한 테스트")
class LottosTest {

    @DisplayName("`Lottos` 생성")
    @Test
    void createLottoGroupTest() {
        // When
        Lottos lottos = new Lottos(Lottos.MIN_LOTTO_SIZE);
        // Then
        assertThat(lottos).isNotNull();
    }

    @DisplayName("잘못된 사이즈로 생성되는 `Lottos`의 예외 확인")
    @Test
    void checkExceptionWithInvalidLottoSizeTest() {
        // Given
        int invalidSize = Lottos.MIN_LOTTO_SIZE - 1;
        // When & Then
        assertThatIllegalArgumentException().isThrownBy(
                () -> new Lottos(invalidSize)
        );
    }

    @DisplayName("`Lottos`의 통계 검색")
    @Test
    void retrieveStatisticsTest() {
        // Given
        Lotto winningLottoNumbers = new Lotto();
        int testLottoSize = 10;
        Lottos lottos = new Lottos(testLottoSize);
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
