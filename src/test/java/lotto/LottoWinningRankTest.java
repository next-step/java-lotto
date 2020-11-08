package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class LottoWinningRankTest {
    @Test
    @DisplayName("당첨번호와 구입한 로또번호로 당첨타입을 확인한다.")
    void winningRank_test() {
        Set<Integer> winningNumbers = new TreeSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));

        assertAll(
                () -> assertThat(LottoWinningRank.getWinningRank(winningNumbers, new TreeSet<>(Arrays.asList(1, 2, 3, 4, 5, 6))))
                        .isEqualTo(LottoWinningRank.MATCHES_SIX),
                () -> assertThat(LottoWinningRank.getWinningRank(winningNumbers, new TreeSet<>(Arrays.asList(1, 2, 3, 4, 5, 7))))
                        .isEqualTo(LottoWinningRank.MATCHES_FIVE),
                () -> assertThat(LottoWinningRank.getWinningRank(winningNumbers, new TreeSet<>(Arrays.asList(1, 2, 3, 4, 7, 8))))
                        .isEqualTo(LottoWinningRank.MATCHES_FOUR),
                () -> assertThat(LottoWinningRank.getWinningRank(winningNumbers, new TreeSet<>(Arrays.asList(1, 2, 3, 7, 8, 9))))
                        .isEqualTo(LottoWinningRank.MATCHES_THREE),
                () -> assertThat(LottoWinningRank.getWinningRank(winningNumbers, new TreeSet<>(Arrays.asList(1, 2, 7, 8, 9, 10))))
                        .isEqualTo(LottoWinningRank.NONE)
        );
    }
}
