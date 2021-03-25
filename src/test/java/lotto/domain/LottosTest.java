package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class LottosTest {

    @Test
    @DisplayName("구입한 로또 개수만큼 객체생성")
    void of() {
        Lottos lottos = Lottos.of(5);
        assertThat(lottos.getLottos()).hasSize(5);
    }

    @Test
    @DisplayName("당첨통계 구하기 테스트")
    void getWinnerStatistics() {
        Lotto lotto = new Lotto(Arrays.asList(1,2,3,4,5,6));
        List<Lotto> lottoList = new ArrayList<>(Collections.singletonList(lotto));
        Lottos lottos = new Lottos(lottoList);

        WinningNumber winningNumber = new WinningNumber("1,2,3,4,5,6");

        Hit hit = new Hit();
        hit.hittingLottoStatistics(6);

        assertThat(lottos.getWinnerStatistics(winningNumber)).isEqualTo(hit);
    }
}
