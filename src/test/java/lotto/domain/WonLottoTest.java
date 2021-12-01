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
        Lotto test = new Lotto(new LottoNumberFactory().getNonDuplicated());

        WonLotto wonLotto = WonLotto.of(test, new LottoNumber(0));
        assertThat(wonLotto.getLottoRankBy(test)).isEqualTo(Rank.FIRST);
    }

    @Test
    @DisplayName("2등 당첨을 테스트 한다")
    void createWithSecond() {
        Lotto purchase = new Lotto("1,2,3,4,5,7");
        Lotto won = new Lotto("1,2,3,4,5,6");

        WonLotto wonLotto = WonLotto.of(won, new LottoNumber(7));
        assertThat(wonLotto.getLottoRankBy(purchase)).isEqualTo(Rank.SECOND);
    }
}