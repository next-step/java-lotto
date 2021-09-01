package lotto.domain;

import static lotto.domain.Rank.FIFTH;
import static lotto.domain.Rank.FIRST;
import static lotto.domain.Rank.FOURTH;
import static lotto.domain.Rank.SECOND;
import static lotto.domain.Rank.THIRD;
import static lotto.domain.Rank.calculateLottoRankBywinCountAndMatchBonus;
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
            .map(LottoNumber::new)
            .collect(Collectors.toList()));

        Lotto winLotto = new Lotto(Arrays.asList(4, 5, 6, 7, 8, 9)
            .stream()
            .map(LottoNumber::new)
            .collect(Collectors.toList()));

        // when
        Rank result = calculateLottoRankBywinCountAndMatchBonus(lotto.calculateWinCount(winLotto), false);

        // then
        assertThat(result).isEqualTo(Rank.FIFTH);
    }

    @Test
    @DisplayName("로또 당첨개수가 6개면 1등을 반환한다.")
    void firstRankTest() {

        // given
        int input = 6;
        boolean bonus = true;

        // when
        Rank result = calculateLottoRankBywinCountAndMatchBonus(input, bonus);

        // then
        assertThat(result).isEqualTo(FIRST);
    }

    @Test
    @DisplayName("로또 당첨개수가 5개고 보너스번호가 맞으면 2등을 반환한다.")
    void secondRankTest() {

        // given
        int input = 5;
        boolean bonus = true;

        // when
        Rank result = calculateLottoRankBywinCountAndMatchBonus(input, bonus);

        // then
        assertThat(result).isEqualTo(SECOND);
    }

    @Test
    @DisplayName("로또 당첨개수가 5개고 보너스번호가 틀리면 3등을 반환한다.")
    void thirdRankTest() {

        // given
        int input = 5;
        boolean bonus = false;

        // when
        Rank result = calculateLottoRankBywinCountAndMatchBonus(input, bonus);

        // then
        assertThat(result).isEqualTo(THIRD);
    }

    @Test
    @DisplayName("로또 당첨개수가 4개면 4등을 반환한다.")
    void fourthRankTest() {

        // given
        int input = 4;
        boolean bonus = false;

        // when
        Rank result = calculateLottoRankBywinCountAndMatchBonus(input, bonus);

        // then
        assertThat(result).isEqualTo(FOURTH);
    }

    @Test
    @DisplayName("로또 당첨개수가 3개면 5등을 반환한다.")
    void fifthRankTest() {

        // given
        int input = 3;
        boolean bonus = false;

        // when
        Rank result = calculateLottoRankBywinCountAndMatchBonus(input, bonus);

        // then
        assertThat(result).isEqualTo(FIFTH);
    }

}