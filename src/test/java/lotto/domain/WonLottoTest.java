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
        LottoNumberFactory factory = LottoNumberFactory.getInstance();
        Lotto test = new Lotto(factory.getNonDuplicated());

        WonLotto wonLotto = WonLotto.of(test);
        assertThat(wonLotto.getLottoRankBy(test)).isEqualTo(Rank.FIRST);
    }
}