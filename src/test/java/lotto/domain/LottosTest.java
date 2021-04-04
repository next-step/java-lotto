package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class LottosTest {

    @Test
    @DisplayName("구입한 가격만큼 로또 객체생성")
    void of() {
        Lottos lottos = Lottos.newRandomLottos(5000, new RandomGenerator());
        assertThat(lottos.getLottos()).hasSize(5);
    }

    @Test
    @DisplayName("당첨통계 구하기 테스트")
    void getWinnerStatistics() {
        Lottos lottos = Lottos.newRandomLottos(1000, new FixedGenerator("1,2,3,4,5,6"));

        WinningNumber winningNumber = new WinningNumber("1,2,3,4,5,6", new LottoNumber(7));

        Hit hit = new Hit();
        hit.hittingLottoStatistics(6, false);

        assertThat(lottos.getWinnerStatistics(winningNumber, new Hit())).isEqualTo(hit);
    }
}
