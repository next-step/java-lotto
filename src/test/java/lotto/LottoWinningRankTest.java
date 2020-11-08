package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static lotto.LottoWinningRank.MATCHES_FIVE;
import static lotto.LottoWinningRank.MATCHES_FOUR;
import static lotto.LottoWinningRank.MATCHES_SIX;
import static lotto.LottoWinningRank.MATCHES_THREE;
import static lotto.LottoWinningRank.NONE;
import static lotto.LottoWinningRank.getWinningRank;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class LottoWinningRankTest {
    @Test
    @DisplayName("당첨번호와 구입한 로또번호로 당첨타입을 확인한다.")
    void winningRank_test() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        assertAll(
                () -> assertThat(getWinningRank(winningNumbers, Arrays.asList(1, 2, 3, 4, 5, 6)))
                        .isEqualTo(MATCHES_SIX),
                () -> assertThat(getWinningRank(winningNumbers, Arrays.asList(1, 2, 3, 4, 5, 7)))
                        .isEqualTo(MATCHES_FIVE),
                () -> assertThat(getWinningRank(winningNumbers, Arrays.asList(1, 2, 3, 4, 7, 8)))
                        .isEqualTo(MATCHES_FOUR),
                () -> assertThat(getWinningRank(winningNumbers, Arrays.asList(1, 2, 3, 7, 8, 9)))
                        .isEqualTo(MATCHES_THREE),
                () -> assertThat(getWinningRank(winningNumbers, Arrays.asList(1, 2, 7, 8, 9, 10)))
                        .isEqualTo(NONE)
        );
    }
}
