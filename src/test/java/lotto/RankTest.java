package lotto;

import lotto.model.Rank;
import lotto.model.gameresult.MatchResults;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static lotto.model.Rank.*;
import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {
    @DisplayName("당첨번호와 일치하는 번호 갯수 및 보너스번호 포함여부를 제공하면, Rank를 알려준다.")
    @Test
    void matchTestWhenFirst() {
        Rank matchResult = Rank.getMatchResult(6, false);

        assertThat(matchResult).isEqualTo(Rank.FIRST);
    }

    @DisplayName("Results 를 주면, 총 상금을 반환한다.")
    @Test
    void getAllPrizeMoneyTest() {
        //given
        List<Rank> ranks = Arrays.asList(BLANK, SECOND, BLANK, FIFTH, BLANK);
        MatchResults matchResults = MatchResults.reflectAll(ranks);

        //when
        int allPrizeMoney = Rank.getAllPrizeMoney(ranks);

        //then
        assertThat(allPrizeMoney).isEqualTo(30_005_000);
    }


    @DisplayName("구입한 로또의 수익률을 구한다.")
    @Test
    void findEarningRateTest(){
        List<Rank> ranks = Arrays.asList(BLANK, SECOND, FIFTH, BLANK, BLANK);

        double earningRate = Rank.findEarningRate(ranks);

        assertThat(earningRate).isEqualTo((30_005_000 / 5_000) * 100);
    }
}