package AutoLotto.domain.play;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RankTest {

    @Test
    void canCreateRankOfMatch() {
        assertThat(Rank.matchOf(6).rankMoney).isEqualTo(2000000000);
        assertThat(Rank.matchOf(3).rankMoney).isEqualTo(5000);
        assertThat(Rank.matchOf(3).matchCount).isEqualTo(3);
        assertThat(Rank.matchOf(3)).isEqualTo(Rank.FOURTH);
    }

    @Test
    void canCreateBuzzMoney() {
//        int sum = 0;
//        List<Integer> list = new ArrayList<>();
//        list.add(1);
//        list.add(2);
//        list.add(2);
//        int hitsSecond = list.stream( )
//                .filter(o -> o == Rank.SECOND.getHits())
//                .mapToInt(i -> i)
//                .sum();
//        assertThat(hitsSecond).isEqualTo(2);
////        sum += hitsSecond * Rank.SECOND.rankMoney;
////        assertThat(sum).isEqualTo(1500000 * 2);
    }
}