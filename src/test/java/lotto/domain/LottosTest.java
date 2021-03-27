package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class LottosTest {

    @Test
    @DisplayName("구입한 가격만큼 로또 객체생성")
    void of() {
        Lottos lottos = Lottos.of(5000);
        assertThat(lottos.getLottos()).hasSize(5);
    }

    @Test
    @DisplayName("당첨통계 구하기 테스트")
    void getWinnerStatistics() {
        List<Integer> referenceNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lottos lottos = Lottos.of(1000, new FixedGenerator(referenceNumbers));

        WinningNumber winningNumber = new WinningNumber("1,2,3,4,5,6");

        Hit hit = new Hit();
        hit.hittingLottoStatistics(6);

        assertThat(lottos.getWinnerStatistics(winningNumber)).isEqualTo(hit);
    }
}
