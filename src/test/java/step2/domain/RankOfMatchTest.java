package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class RankOfMatchTest {

    @DisplayName("매칭된 로또들을 그룹화한다.")
    @Test
    void matchOfLotto_계산() {
        //given
        List<Integer> matchResult = List.of(5, 5, 6, 6, 4, 4);
        RankOfMatch rankOfMatch = new RankOfMatch(matchResult);
        List<Boolean> matchOfBonus = List.of(true, false, true, false, true, false);

        //when
        Map<Integer, Long> matchGroup = rankOfMatch.groupMatchOfLotto(matchOfBonus.iterator());

        //then
        assertThat(matchGroup.get(2_000_000_000)).isEqualTo(2);
        assertThat(matchGroup.get(30_000_000)).isEqualTo(1);
        assertThat(matchGroup.get(1_500_000)).isEqualTo(1);
        assertThat(matchGroup.get(50_000)).isEqualTo(2);
    }
}