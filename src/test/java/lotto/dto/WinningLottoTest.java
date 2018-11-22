package lotto.dto;

import lotto.vo.LottoNum;
import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningLottoTest {


    private WinningLotto wl;

    @Before
    public void init(){
        Set<LottoNum> lotto = Stream.of(1, 2, 3, 4, 5, 6).map(e -> LottoNum.of(e)).collect(Collectors.toSet());
        wl = new WinningLotto(new Lotto(lotto),7);
    }

    @Test
    public void 로또_랭크구하기_일등() {
        Set<LottoNum> lotto = Stream.of(1, 2, 3, 4, 5, 6).map(e -> LottoNum.of(e)).collect(Collectors.toSet());

        assertThat(wl.matchOf(new Lotto(lotto))).isEqualTo(Rank.FIRST);

    }

    @Test
    public void 로또_랭크구하기_이등() {
        Set<LottoNum> lotto = Stream.of(1, 2, 3, 4, 7, 9).map(e -> LottoNum.of(e)).collect(Collectors.toSet());

        assertThat(wl.matchOf(new Lotto(lotto))).isEqualTo(Rank.SECOND);

    }

    @Test
    public void 로또_랭크구하기_삼등() {
        Set<LottoNum> lotto = Stream.of(1, 2, 3, 4, 5, 9).map(e -> LottoNum.of(e)).collect(Collectors.toSet());

        assertThat(wl.matchOf(new Lotto(lotto))).isEqualTo(Rank.THIRD);

    }

    @Test
    public void 로또_랭크구하기_사등() {
        Set<LottoNum> lotto = Stream.of(1, 2, 3, 4, 10, 9).map(e -> LottoNum.of(e)).collect(Collectors.toSet());

        assertThat(wl.matchOf(new Lotto(lotto))).isEqualTo(Rank.FOURTH);

    }

    @Test
    public void 매칭된갯수구하기() {
        Set<LottoNum> lotto1 = Stream.of(1, 2, 3, 4, 5, 6).map(e -> LottoNum.of(e)).collect(Collectors.toSet());
        Set<LottoNum> lotto2 = Stream.of(1, 2, 3, 4, 7, 9).map(e -> LottoNum.of(e)).collect(Collectors.toSet());
        Set<LottoNum> lotto3 = Stream.of(1, 2, 3, 4, 5, 9).map(e -> LottoNum.of(e)).collect(Collectors.toSet());
        Set<LottoNum> lotto4 = Stream.of(1, 2, 3, 4, 10, 9).map(e -> LottoNum.of(e)).collect(Collectors.toSet());
        List<Lotto> lottos = Arrays.asList(new Lotto(lotto1),new Lotto(lotto2),new Lotto(lotto3),new Lotto(lotto4));

        assertThat(wl.match(lottos).get(Rank.FIRST)).isEqualTo(1);
        assertThat(wl.match(lottos).get(Rank.SECOND)).isEqualTo(1);
        assertThat(wl.match(lottos).get(Rank.THIRD)).isEqualTo(1);
        assertThat(wl.match(lottos).get(Rank.FOURTH)).isEqualTo(1);
    }

    @Test
    public void 맵초기화() {

        Map<Rank, Integer> maps = wl.initailize();
        for(Rank rank : Rank.values()){
            assertThat(maps.get(rank)).isEqualTo(0);
        }
        assertThat(maps).hasSize(6);
    }
}