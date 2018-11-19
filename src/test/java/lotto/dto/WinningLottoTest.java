package lotto.dto;

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
        Set<Integer> lotto = Stream.of(1, 2, 3, 4, 5, 6).collect(Collectors.toSet());
        wl = new WinningLotto(new Lotto(lotto),7);
    }

    @Test
    public void 로또_랭크구하기_일등() {
        Set<Integer> lotto = Stream.of(1, 2, 3, 4, 5, 6).collect(Collectors.toSet());

        assertThat(wl.matchOf(new Lotto(lotto))).isEqualTo(Rank.FIRST);

    }

    @Test
    public void 로또_랭크구하기_이등() {
        Set<Integer> lotto = Stream.of(1, 2, 3, 4, 7, 9).collect(Collectors.toSet());

        assertThat(wl.matchOf(new Lotto(lotto))).isEqualTo(Rank.SECOND);

    }

    @Test
    public void 로또_랭크구하기_삼등() {
        Set<Integer> lotto = Stream.of(1, 2, 3, 4, 5, 9).collect(Collectors.toSet());

        assertThat(wl.matchOf(new Lotto(lotto))).isEqualTo(Rank.THIRD);

    }

    @Test
    public void 로또_랭크구하기_사등() {
        Set<Integer> lotto = Stream.of(1, 2, 3, 4, 10, 9).collect(Collectors.toSet());

        assertThat(wl.matchOf(new Lotto(lotto))).isEqualTo(Rank.FOURTH);

    }

    @Test
    public void 매칭된갯수구하기() {
        Set<Integer> lotto1 = Stream.of(1, 2, 3, 4, 5, 6).collect(Collectors.toSet());
        Set<Integer> lotto2 = Stream.of(1, 2, 3, 4, 7, 9).collect(Collectors.toSet());
        Set<Integer> lotto3 = Stream.of(1, 2, 3, 4, 5, 9).collect(Collectors.toSet());
        Set<Integer> lotto4 = Stream.of(1, 2, 3, 4, 10, 9).collect(Collectors.toSet());
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