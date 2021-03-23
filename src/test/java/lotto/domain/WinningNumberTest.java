package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class WinningNumberTest {

    @Test
    @DisplayName("로또 당첨 통계 테스트")
    void getWinnerStatistics() {
        WinningNumber winningNumbers = new WinningNumber("1,2,3,4,5,6");
        Lottos lottos = new Lottos(Collections.singletonList(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6))));

        Hit hit = new Hit();
        hit.hittingLottoStatistics(6);

        assertThat(winningNumbers.getWinnerStatistics(lottos)).isEqualTo(hit);
    }
}
