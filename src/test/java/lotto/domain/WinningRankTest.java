package lotto.domain;

import lotto.vo.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class WinningRankTest {

    @DisplayName("match count 에 맞는 enum을 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"6:1:2000000000", "5:2:1500000", "4:3:50000", "3:4:5000"}, delimiter = ':')
    void getWinningRankTest(long matchCount, int rank, int reward) {
        WinningRank winningRank = WinningRank.getWinningRankWithMatchCount(matchCount);

        assertThat(winningRank.getRank()).isEqualTo(rank);
        assertThat(winningRank.getReward()).isEqualTo(Money.create(reward));
    }

    @DisplayName("match count 가 3보다 작으면 NO_RANK를 반환한다.")
    @ParameterizedTest
    @ValueSource(longs = {2l, 1l, 0l})
    void getNoRankTest(long matchCount) {
        WinningRank winningRank = WinningRank.getWinningRankWithMatchCount(matchCount);

        assertThat(winningRank).isEqualTo(WinningRank.NO_RANK);
    }


}
