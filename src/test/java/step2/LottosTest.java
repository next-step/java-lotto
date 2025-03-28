package step2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import step2.domain.*;

import java.util.List;

import static step2.util.LottoNumberUtils.of;

public class LottosTest {
    @Test
    void matchAll() {
        List<Lotto> lottoList = List.of(
                new Lotto(of(1, 2, 3, 4, 5, 6)), // 6개 동일
                new Lotto(of(2, 3, 4, 5, 6, 18)), // 5개 동일 + bonus 동일
                new Lotto(of(2, 3, 4, 5, 6, 7)), // 5개 동일
                new Lotto(of(13, 14, 15, 16, 17, 18)) // 0개 동일
        );
        Lottos lottos = new Lottos(lottoList);
        Winning winning = new Winning(of(1, 2, 3, 4, 5, 6), new LottoNum(18));
        List<MatchResult> matchResults = lottos.matchAll(winning);

        Assertions.assertThat(matchResults)
                .extracting(MatchResult::getRank)
                .containsExactly(Rank.FIRST, Rank.SECOND, Rank.THIRD, Rank.NONE);
    }
}
