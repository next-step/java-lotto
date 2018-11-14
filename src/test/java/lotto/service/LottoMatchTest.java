package lotto.service;

import lotto.dto.Lotto;
import lotto.dto.LottoEnum;
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
        Map<LottoEnum,Integer> temp = lm.getMatch();
        assertThat(temp).hasSize(4);
        /** 초기값 0 출력 확인
         *
         */
        System.out.println(lm.getMatch().get(LottoEnum.THREE));
        System.out.println(lm.getMatch().get(LottoEnum.FOUR));
        System.out.println(lm.getMatch().get(LottoEnum.FIVE));
        System.out.println(lm.getMatch().get(LottoEnum.SIX));


    }

    @Test
    public void 매칭결과_MAP반환() {
        LottoMatch lm = new LottoMatch(Arrays.asList(1,2,3,4,5,6));
        List<Lotto> lottos = new ArrayList<>(Arrays.asList(new Lotto(), new Lotto()));
        Map<LottoEnum,Integer> maps = lm.getMatchNum(lottos);
        assertThat(maps.get(LottoEnum.THREE)).isEqualTo(0);
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

    @Test
    public void ENUM반환() {
        assertThat(LottoMatch.getEnumMatch(3)).isEqualTo(LottoEnum.THREE);
        assertThat(LottoMatch.getEnumMatch(4)).isEqualTo(LottoEnum.FOUR);
        assertThat(LottoMatch.getEnumMatch(5)).isEqualTo(LottoEnum.FIVE);
        assertThat(LottoMatch.getEnumMatch(6)).isEqualTo(LottoEnum.SIX);

    }
}
