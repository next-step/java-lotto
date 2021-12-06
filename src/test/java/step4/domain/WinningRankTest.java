package step4.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinningRankTest {

    @DisplayName("WinningRank를 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {
            "1,2,3,4,5,6:7:1,2,3,4,5,6:FIRST_RANK",
            "1,2,3,4,5,6:7:1,2,3,4,5,7:SECOND_RANK",
            "1,2,3,4,5,6:7:1,2,3,4,5,8:THIRD_RANK",
            "1,2,3,4,5,6:7:1,2,3,4,8,9:FOURTH_RANK",
            "1,2,3,4,5,6:7:1,2,3,7,8,9:FIFTH_RANK"
    }, delimiter = ':')
    void winningRankTest(String winningLottoString, String bonus, String lottoString, String rankName) {
        WinningLotto winningLotto = WinningLotto.of(winningLottoString, bonus);
        Lottos lottos = Lottos.of(Arrays.asList(Lotto.of(lottoString)));
        WinningRank winningRank = WinningRank.valueOf(rankName);
        assertThat(WinningRank.findWinningRanks(lottos, winningLotto)).containsExactly(winningRank);
    }

    @DisplayName("match count 가 3보다 작으면 NO_RANK를 반환한다.")
    @ParameterizedTest
    @ValueSource(longs = {2l, 1l, 0l})
    void getNoRankTest(long matchCount) {
        WinningRank winningRank = WinningRank.valueOf(matchCount);

        assertThat(winningRank).isEqualTo(WinningRank.NO_RANK);
    }

    @DisplayName("No rank 를 포함한 랭크를 fifth, fourth, third, second, first 순으로 반환한다.")
    @Test
    void getWinningListTest() {
        List<WinningRank> winningRankListWithoutNoRank = WinningRank.getReverseRankListWithoutNoRank();

        List<WinningRank> expect = Arrays.asList(WinningRank.FIFTH_RANK, WinningRank.FOURTH_RANK, WinningRank.THIRD_RANK, WinningRank.SECOND_RANK, WinningRank.FIRST_RANK);
        assertThat(winningRankListWithoutNoRank).isEqualTo(expect);
    }

    @DisplayName("맞는 값이 5개인 경우 보너스볼을 기준으로 2등 3등이 나뉜다")
    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5,6:1,2,3,4,5,7:6:SECOND_RANK", "1,2,3,4,5,6:1,2,3,4,5,8:7:THIRD_RANK"}, delimiter = ':')
    void getWinningRankWithLottoTest(String lottoStr, String winningLottoStr, String bonusBallValue, String rank) {
        Lotto lotto = Lotto.of(lottoStr);
        WinningLotto winningLotto = WinningLotto.of(winningLottoStr, bonusBallValue);

        List<WinningRank> winningRanks = WinningRank.findWinningRanks(Lottos.of(Arrays.asList(lotto)), winningLotto);
        WinningRank expect = WinningRank.valueOf(rank);

        assertThat(winningRanks).containsOnly(expect);
    }

}
