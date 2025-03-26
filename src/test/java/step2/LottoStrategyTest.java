package step2;

import org.junit.jupiter.api.Test;
import step2.domain.Lotto;
import step2.domain.MatchResult;
import step2.domain.Winning;
import step2.util.FixLottoStrategy;
import step2.util.LottoStrategy;

import static org.assertj.core.api.Assertions.assertThat;
import static step2.util.LottoNumberUtils.of;

public class LottoStrategyTest {

    @Test
    void fixLottoNums() {
        LottoStrategy lottoStrategy = new FixLottoStrategy(of(2, 4, 5, 6, 7, 8));
        Lotto lotto = new Lotto(lottoStrategy.generateLottoNumbers());
        Winning winning = new Winning(of(1,3,4,5,6,8));
        MatchResult matchResult = winning.match(lotto);
        assertThat(matchResult.getMatchedCount()).isEqualTo(4);
    }

    @Test
    void isSameCount() {
        LottoStrategy lottoStrategy = new FixLottoStrategy(of(2, 4, 5, 6, 7, 8));
        Lotto lotto = new Lotto(lottoStrategy.generateLottoNumbers());
        Winning winning = new Winning(of(1,3,4,5,6,8));
        MatchResult matchResult = winning.match(lotto);

        assertThat(matchResult.getMatchedCount()).isEqualTo(4);
    }
}
