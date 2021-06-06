package lotto;

import lotto.domain.Lotto;
import lotto.domain.entity.LottoPrice;
import lotto.domain.Result;
import lotto.domain.entity.LottoList;
import lotto.domain.entity.Number;
import lotto.domain.RankCounter;
import lotto.domain.entity.Rank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class RankCounterTest {

    private LottoList lottoList;
    private Lotto winningLotto;
    private Number bonusNumber;

    @BeforeEach
    public void setUp(){
        lottoList = new LottoList(
                new Lotto(Arrays.asList(1,2,3,4,5,6)) // 1등
                , new Lotto(Arrays.asList(1,2,3,4,5,10)) // 2등
                , new Lotto(Arrays.asList(1,2,3,4,5,11)) // 3등
                , new Lotto(Arrays.asList(1,2,3,4,20,21)) // 4등
                , new Lotto(Arrays.asList(1,2,3,20,21,22)) // 5등
        );
        winningLotto = new Lotto(Arrays.asList(1,2,3,4,5,6));
        bonusNumber = Number.of(10);
    }

    @Test
    @DisplayName("일치하는 숫자에 등수를 확인한다.")
    public void 등수_확인() {
        Result result = new Result(winningLotto, bonusNumber);
        result.confirm(lottoList, new LottoPrice("1000"));
        RankCounter rankCounter = result.rank();

        assertThat(rankCounter.countByRank(Rank.FIRST)).isEqualTo(1);
        assertThat(rankCounter.countByRank(Rank.SECOND)).isEqualTo(1);
        assertThat(rankCounter.countByRank(Rank.THIRD)).isEqualTo(1);
        assertThat(rankCounter.countByRank(Rank.FOURTH)).isEqualTo(1);
        assertThat(rankCounter.countByRank(Rank.FIFTH)).isEqualTo(1);
    }

    @Test
    @DisplayName("entryForEach() 확인")
    public void 엔트리_순회_확인() {
        RankCounter rankCounter = new RankCounter();
        rankCounter.entryForEach((rank, integer) -> {
            assertThat(rank).isNull();
            assertThat(integer).isNull();
        });

        lottoList = new LottoList(new Lotto(Arrays.asList(1,2,3,4,5,6))); // 1등
        rankCounter.counting(lottoList, winningLotto, bonusNumber);
        rankCounter.entryForEach((rank, integer) -> {
            assertThat(rank.winningMoney()).isEqualTo(Rank.FIRST.winningMoney());
            assertThat(integer).isEqualTo(1);
        });

    }
}
