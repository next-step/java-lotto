package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningLottoTest {
    @Test
    void createTest() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoNumber bonusNo = new LottoNumber(7);
        WinningLotto winningLotto = new WinningLotto(lotto, bonusNo);

        assertThat(winningLotto).isNotNull();
    }

    @DisplayName("당첨번호에 포함된 보너스 번호가 존재할 수 없다.")
    @Test
    void calculateInvalidTest() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoNumber bonusNo = new LottoNumber(6);

        assertThatThrownBy(() -> new WinningLotto(lotto, bonusNo)).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("bonusNo is matched with lotto");
    }

    @Test
    void calculateRankTest() {
        // given
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoNumber bonusNo = new LottoNumber(7);
        WinningLotto winningLotto = new WinningLotto(lotto, bonusNo);

        // when
        Lotto lottoTicket = new Lotto(Arrays.asList(1, 2, 3, 7, 5, 6));

        // then
        assertThat(winningLotto.calculateRank(lottoTicket)).isEqualTo(Rank.SECOND);
    }
}
