package AutoLotto.domain.lotto;

import AutoLotto.domain.play.Rank;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BuzzLottoTest {

    @Test
    void canFindRankByMatch() {
        UserLotto userLotto1 = new UserLotto(Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5), new LottoNumber(6))); //3
        UserLotto userLotto2 = new UserLotto(Arrays.asList(new LottoNumber(1), new LottoNumber(3), new LottoNumber(4),
                new LottoNumber(8), new LottoNumber(16), new LottoNumber(32))); //2
        UserLotto userLotto3 = new UserLotto(Arrays.asList(new LottoNumber(4), new LottoNumber(6), new LottoNumber(8),
                new LottoNumber(10), new LottoNumber(12), new LottoNumber(14))); //5

        BuzzLotto buzzLotto = new BuzzLotto(Arrays.asList(new LottoNumber(2), new LottoNumber(4), new LottoNumber(6),
                new LottoNumber(8), new LottoNumber(10), new LottoNumber(12)));

        assertThat(buzzLotto.findRankByMatch(userLotto1)).isEqualTo(Rank.FOURTH);
        assertThat(buzzLotto.findRankByMatch(userLotto2)).isEqualTo(Rank.FIFTH);
        assertThat(buzzLotto.findRankByMatch(userLotto3)).isEqualTo(Rank.SECOND);

    }

    @Test
    void canCountMatchAll() {
        UserLotto userLotto1 = new UserLotto(Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5), new LottoNumber(6))); //3
        UserLotto userLotto2 = new UserLotto(Arrays.asList(new LottoNumber(1), new LottoNumber(3), new LottoNumber(4),
                new LottoNumber(8), new LottoNumber(16), new LottoNumber(32))); //2
        UserLotto userLotto3 = new UserLotto(Arrays.asList(new LottoNumber(4), new LottoNumber(6), new LottoNumber(8),
                new LottoNumber(10), new LottoNumber(12), new LottoNumber(14))); //5

        List<UserLotto> userLottos = Arrays.asList(userLotto1, userLotto2, userLotto3);

        BuzzLotto buzzLotto = new BuzzLotto(Arrays.asList(new LottoNumber(2), new LottoNumber(4), new LottoNumber(6),
                new LottoNumber(8), new LottoNumber(10), new LottoNumber(12)));

        assertThat(buzzLotto.countMatchAll(userLottos)).hasSize(3).containsExactly(3,2,5);
    }

}