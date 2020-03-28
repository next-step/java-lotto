package lotto.domain;

import lotto.Fixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoBundleTest {

    @DisplayName("로또 번들 정상 생성")
    @Test
    void createLottoBundle() {
        LottoBundle lottoBundle = new LottoBundle(Arrays.asList(Fixture.lottoOne()));

        assertThat(lottoBundle).isNotNull();
        assertThat(lottoBundle.size()).isEqualTo(1);
    }

    @DisplayName("로또 번들 생성 실패")
    @ParameterizedTest
    @NullAndEmptySource
    void createFailByNullAndEmpty(List<Lotto> lottos) {
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoBundle(lottos));
    }

    @DisplayName("로또 당첨 조회")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6"})
    void lottery(String winningNumber) {
        LottoBundle lottoBundle = new LottoBundle(Arrays.asList(Fixture.lottoOne(), Fixture.lottoTwo()));
        List<WinningType> actual = lottoBundle.lottery(winningNumber);

        assertThat(actual).isNotNull();
    }

}