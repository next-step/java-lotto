package lotto.service;

import lotto.dto.Lotto;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMatchTest {

    @Test
    public void 매칭결과테스트() {

        LottoMatch lm = new LottoMatch(new ArrayList<>(Arrays.asList(1,2,3,4,5,6)));
        Map<Integer,Integer> temp = lm.getMatch();
        assertThat(temp).hasSize(4);
        /** 초기값 0 출력 확인
         *
         */
        System.out.println(lm.getMatch().get(3));
        System.out.println(lm.getMatch().get(4));
        System.out.println(lm.getMatch().get(5));
        System.out.println(lm.getMatch().get(6));


    }

    @Test
    public void 매칭결과_MAP반환() {
        LottoMatch lm = new LottoMatch(new ArrayList<>(Arrays.asList(1,2,3,4,5,6)));
        List<Lotto> lottos = new ArrayList<>(Arrays.asList(new Lotto(), new Lotto()));
        Map<Integer,Integer> maps = lm.getMatchNum(lottos);
        assertThat(maps.get(3)).isEqualTo(0);
    }

    @Test
    public void 중복검사테스트() {
        List<Integer> winnerNums = new ArrayList<>(Arrays.asList(1,2,3,4,5,6));
        Lotto lotto1 = new Lotto();
        Lotto lotto2 = new Lotto();
        List<Lotto> lottos = new ArrayList<>(Arrays.asList(lotto1, lotto2));

        System.out.println(Arrays.toString(lotto1.getLotto().toArray()));
        System.out.println(Arrays.toString(lotto2.getLotto().toArray()));
        for(Lotto lotto : lottos){
            System.out.println(LottoMatch.duplicatedCounts(lotto.getLotto(),winnerNums));
        }


    }
}
