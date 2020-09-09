package AutoLotto.domain.lotto;

import AutoLotto.domain.play.PlayLotto;
import AutoLotto.domain.play.Rank;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BuzzLottoTest {

    @Test
    void canMatch() {
        BuzzLotto buzzLotto = new BuzzLotto(Arrays.asList(new LottoNumber(2), new LottoNumber(4), new LottoNumber(6),
                new LottoNumber(8), new LottoNumber(10), new LottoNumber(12)));

        List<LottoNumber> userLotto1 = Arrays.asList(new LottoNumber(45), new LottoNumber(7), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(17), new LottoNumber(31));

        List<LottoNumber> userLotto2 = Arrays.asList(new LottoNumber(45), new LottoNumber(7), new LottoNumber(12),
                new LottoNumber(4), new LottoNumber(8), new LottoNumber(31));

        assertThat(buzzLotto.countMatch(userLotto1)).isEqualTo(1);
        assertThat(buzzLotto.countMatch(userLotto2)).isEqualTo(3);
    }

    @Test
    void canFindRankByMatch() {
        List<LottoNumber> userLotto1 = Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)); //3
        List<LottoNumber> userLotto2 = Arrays.asList(new LottoNumber(1), new LottoNumber(3), new LottoNumber(4),
                new LottoNumber(8), new LottoNumber(16), new LottoNumber(32)); //2
        List<LottoNumber> userLotto3 = Arrays.asList(new LottoNumber(4), new LottoNumber(6), new LottoNumber(8),
                new LottoNumber(10), new LottoNumber(12), new LottoNumber(14)); //5

        BuzzLotto buzzLotto = new BuzzLotto(Arrays.asList(new LottoNumber(2), new LottoNumber(4), new LottoNumber(6),
                new LottoNumber(8), new LottoNumber(10), new LottoNumber(12)));

        assertThat(buzzLotto.findRankByMatch(userLotto1)).isEqualTo(Rank.FOURTH);
        assertThat(buzzLotto.findRankByMatch(userLotto2)).isEqualTo(Rank.FIFTH);
        assertThat(buzzLotto.findRankByMatch(userLotto3)).isEqualTo(Rank.SECOND);

    }
}