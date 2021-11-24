package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author han
 */
public class LottoTest {

    @Test
    @DisplayName("로또 자동 생성")
    void create() {
        Lotto byAuto = Lotto.createByAuto();
        assertThat(byAuto.getNumbers().size()).isEqualTo(6);
    }

    @Test
    @DisplayName("당첨 로또 생성")
    void createWithWon() {
        Lotto test = Lotto.createByAuto();

        WonLotto wonLotto = WonLotto.of(test);
        assertThat(wonLotto.getLottoRankBy(test)).isEqualTo(Rank.FIRST);
    }
}
