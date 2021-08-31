package lotto.domain;

import static lotto.domain.Rank.calculateLottoRank;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RankTest {

    @Test
    @DisplayName("로또 번호를 가지고 로또 등수를 확인할 수 있다.")
    void calculateRankTest() {

        // given
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)
            .stream()
            .map(Number::new)
            .collect(Collectors.toList()));

        Lotto winLotto = new Lotto(Arrays.asList(4, 5, 6, 7, 8, 9)
            .stream()
            .map(Number::new)
            .collect(Collectors.toList()));

        // when
        Rank result = calculateLottoRank(lotto.calculateWinCount(winLotto));

        // then
        assertThat(result).isEqualTo(Rank.FIFTH);
    }

}