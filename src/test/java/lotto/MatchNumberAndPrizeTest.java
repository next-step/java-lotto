package lotto;

import lotto.domain.enums.MatchNumberAndPrize;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class MatchNumberAndPrizeTest {

    @Test
    @DisplayName("총 당첨금액을 계산한다")
    void sumWinningAmount() {
        Map<MatchNumberAndPrize, Integer> map = new HashMap<>();
        map.put(MatchNumberAndPrize.FIRST, 1);
        map.put(MatchNumberAndPrize.FOURTH, 2);

        Long result = MatchNumberAndPrize.sumWinningAmount(map);

        Long expect = (MatchNumberAndPrize.FIRST.getPrize()) +
                (MatchNumberAndPrize.FOURTH.getPrize() * 2);

        assertThat(result).isEqualTo(expect);
    }

    @ParameterizedTest
    @ValueSource(ints = {3, 4, 5, 6})
    @DisplayName("맞춘 숫자와 일치하는 객체를 반환한다")
    void valueOfMatchNumber(int matchNumber) {

        MatchNumberAndPrize matchNumberAndPrize =
                MatchNumberAndPrize.valueOfMatchNumber(matchNumber, false);

        assertThat(matchNumberAndPrize.getMatchNumber()).isEqualTo(matchNumber);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2})
    @DisplayName("맞춘 숫자가 없으면 NON을 반환한다.")
    void valueOfMatchNumberNON(int matchNumber) {
        MatchNumberAndPrize matchNumberAndPrize =
                MatchNumberAndPrize.valueOfMatchNumber(matchNumber, false);

        assertThat(matchNumberAndPrize).isEqualTo(MatchNumberAndPrize.NON);
    }

    @Test
    @DisplayName("5개의 당첨 개수와 보너스볼을 맞추면 2등을 반환한다")
    void valueOfBonusMatchNumber() {
        MatchNumberAndPrize matchNumberAndPrize =
                MatchNumberAndPrize.valueOfMatchNumber(MatchNumberAndPrize.SECOND_MATCH_NUMBER, true);

        assertThat(matchNumberAndPrize).isEqualTo(MatchNumberAndPrize.SECOND);
    }
}