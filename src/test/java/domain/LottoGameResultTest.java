package domain;

import domain.lotto.Rank;
import org.junit.jupiter.api.Test;

import java.util.List;

class LottoGameResultTest {

    @Test
    void lottoGameResultTest() {
        List<Rank> ranks = List.of(Rank.FIRST);
        LottoGameResult lottoGameResult = new LottoGameResult(ranks);

        RankCounter actual = lottoGameResult.getRankCounters();
        RankCounter excepted = new RankCounter();
        excepted.increaseCount(Rank.FIRST);

    }

}