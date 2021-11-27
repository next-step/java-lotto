package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author han
 */
class WonLottoTest {

    @Test
    @DisplayName("1등 당첨을 테스트 한다")
    void createWithWon() {
        Lotto test = new Lotto(LottoNumber.createNonDuplicated());

        WonLotto wonLotto = WonLotto.of(test);
        assertThat(wonLotto.getLottoRankBy(test)).isEqualTo(Rank.FIRST);
    }
}