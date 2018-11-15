package lotto.service;

import lotto.dto.Lotto;
import lotto.dto.Rank;
import lotto.dto.WinningLotto;
import lotto.utils.MatchUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMatchTest {

    @Test
    public void 매칭결과테스트() {

        LottoMatch lm = new LottoMatch(new WinningLotto(Arrays.asList(1, 2, 3, 4, 5, 6), 7));
        Map<Rank, Integer> temp = lm.getMatch();
        assertThat(temp).hasSize(6);
        /** 초기값 0 출력 확인
         *
         */
        System.out.println(lm.getMatch().get(Rank.FIRST));
        System.out.println(lm.getMatch().get(Rank.SECOND));
        System.out.println(lm.getMatch().get(Rank.THIRD));
        System.out.println(lm.getMatch().get(Rank.FOURTH));
        System.out.println(lm.getMatch().get(Rank.FIFTH));
        System.out.println(lm.getMatch().get(Rank.MISS));


    }

    @Test
    public void 매칭결과_MAP반환_FOURTH() {
        LottoMatch lm = new LottoMatch(new WinningLotto(Arrays.asList(1, 2, 3, 4, 5, 6), 7));
        List<Lotto> lottos = Arrays.asList(
                new Lotto(new ArrayList<>(Arrays.asList(1,2,3,4)))
        );
        Map<Rank, Integer> maps = lm.getMatchNum(lottos);
        for(Rank rank : Rank.values()){
            System.out.println(rank + " " + maps.get(rank));
        }
        assertThat(maps.get(Rank.FOURTH)).isEqualTo(1);
    }


    @Test
    public void 매칭결과_MAP반환_SECOND() {
        LottoMatch lm = new LottoMatch(new WinningLotto(Arrays.asList(1, 2, 3, 4, 5, 6), 7));
        List<Lotto> lottos = Arrays.asList(
                new Lotto(new ArrayList<>(Arrays.asList(1,2,3,4,7)))
        );
        Map<Rank, Integer> maps = lm.getMatchNum(lottos);
        for(Rank rank : Rank.values()){
            System.out.println(rank + " " + maps.get(rank));
        }
        assertThat(maps.get(Rank.SECOND)).isEqualTo(1);
    }


    @Test
    public void 매칭결과_MAP반환_THIRD() {
        LottoMatch lm = new LottoMatch(new WinningLotto(Arrays.asList(1, 2, 3, 4, 5, 6), 7));
        List<Lotto> lottos = Arrays.asList(
                new Lotto(new ArrayList<>(Arrays.asList(1,2,3,4,5)))
        );
        Map<Rank, Integer> maps = lm.getMatchNum(lottos);
        for(Rank rank : Rank.values()){
            System.out.println(rank + " " + maps.get(rank));
        }
        assertThat(maps.get(Rank.THIRD)).isEqualTo(1);
    }

    @Test
    public void 중복검사테스트() {
        List<Integer> winnerNums = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto lotto1 = new Lotto();
        Lotto lotto2 = new Lotto();
        Lotto temp = new Lotto(new ArrayList<>(lotto2.getLotto().subList(0, 4)));
        temp.getLotto().add(9);
        WinningLotto wl = new WinningLotto(temp.getLotto(), lotto2.getLotto().get(5));
        List<Lotto> lottos = new ArrayList<>(Arrays.asList(lotto1, lotto2));
        LottoMatch lm = new LottoMatch(wl);

        System.out.println(Arrays.toString(lotto1.getLotto().toArray()));
        System.out.println(Arrays.toString(lotto2.getLotto().toArray()));
        System.out.println(Arrays.toString(wl.getWinnerNums().toArray()) + " , " + wl.getBonusNum());

        //assertThat(lm.getRankFromDuplicateCount(lotto1.getLotto(), wl)).isEqualTo(Rank.MISS);
        assertThat(lm.getRankFromDuplicateCount(lotto2.getLotto(), wl)).isEqualTo(Rank.SECOND);
    }

    /**
     * Rank로 대체됨
     *

     @Deprecated public void ENUM반환() {
     assertThat(LottoMatch.getEnumMatch(3)).isEqualTo(Rank.FIFTH);
     assertThat(LottoMatch.getEnumMatch(4)).isEqualTo(Rank.FOURTH);
     assertThat(LottoMatch.getEnumMatch(5)).isEqualTo(Rank.SECOND);
     assertThat(LottoMatch.getEnumMatch(6)).isEqualTo(Rank.FIRST);

     }
     */
}
