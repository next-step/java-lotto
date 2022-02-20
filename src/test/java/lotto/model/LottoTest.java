package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

class LottoTest {

    @Test
    void 로또는_숫자_여섯개() {
        Lotto lotto = new Lotto(Arrays.asList(
            new LottoNumber(2), new LottoNumber(4), new LottoNumber(8), new LottoNumber(41),
            new LottoNumber(15),
            new LottoNumber(20)
        ));
        assertThat(lotto.getLottoNumbers().size()).isEqualTo(6);
    }

    @Test
    void 여섯개가_아닌_숫자가_들어오면_로또생성은_실패한다() {
        assertThatThrownBy(() -> new Lotto(Arrays.asList(new LottoNumber(2), new LottoNumber(4),
            new LottoNumber(8), new LottoNumber(41), new LottoNumber(15))));
    }

    @Test
    void 당첨번호와_로또번호를_비교한다() {
        Lotto lotto = new Lotto(Arrays.asList(
            new LottoNumber(2), new LottoNumber(4), new LottoNumber(8), new LottoNumber(41),
            new LottoNumber(15),
            new LottoNumber(20)
        ));
        WinningNumber winningNumber = new WinningNumber(
            Arrays.asList(2, 4, 5, 15, 20, 21), new LottoNumber(9));
        MatchInfo matchInfo = lotto.matchLottoWithWinningNumber(winningNumber);
        assertThat(matchInfo.getMatchCount()).isEqualTo(4);
    }

    @Test
    void 다섯개의_당첨번호와_보너스볼이_일치한다() {
        Lotto lotto = new Lotto(Arrays.asList(
            new LottoNumber(2), new LottoNumber(4), new LottoNumber(8), new LottoNumber(41),
            new LottoNumber(15),
            new LottoNumber(20)
        ));
        WinningNumber winningNumber = new WinningNumber(
            Arrays.asList(2, 4, 8, 15, 20, 21), new LottoNumber(41));
        MatchInfo matchInfo = lotto.matchLottoWithWinningNumber(winningNumber);
        assertThat(matchInfo.getMatchCount()).isEqualTo(5);
        assertThat(matchInfo.getBonusMatch()).isEqualTo(true);
    }

}