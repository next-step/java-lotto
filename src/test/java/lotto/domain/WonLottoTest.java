package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author han
 */
class WonLottoTest {

    @Test
    @DisplayName("1등 당첨을 테스트 한다")
    void createWithWon() {
        Lotto test = Lotto.createByAuto();

        WonLotto wonLotto = WonLotto.of(test);
        assertThat(wonLotto.getLottoRankBy(test)).isEqualTo(Rank.FIRST);
    }
}