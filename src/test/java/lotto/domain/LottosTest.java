package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@DisplayName("구입한 모든 `Lotto`를 가진 `Lottos`에 대한 테스트")
class LottosTest {
    private static final List<Lotto> LOTTOS = Arrays.asList(new Lotto(), new Lotto(), new Lotto());

    @DisplayName("`Lottos` 생성")
    @Test
    void createLottoGroupTest() {
        // when
        Lottos lottos = new Lottos(LOTTOS);
        // then
        assertThat(lottos).isNotNull();
    }

    @DisplayName("잘못된 사이즈로 생성되는 `Lottos`의 예외 확인")
    @ParameterizedTest
    @NullAndEmptySource
    void checkExceptionWithInvalidLottoSizeTest(List<Lotto> lottos) {
        // when & then
        assertThatIllegalArgumentException().isThrownBy(
                () -> new Lottos(lottos)
        );
    }

    @DisplayName("`Lottos`의 통계 검색")
    @Test
    void retrieveStatisticsTest() {
        // given
        Lottos lottos = new Lottos(LOTTOS);
        Lotto winningLotto = new Lotto();
        // when
        LottoResult lottoResult = lottos.lottoResult(winningLotto);
        // then
        assertThat(lottoResult).isNotNull();
    }
}
