package im.juniq.lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

import java.util.Arrays;
import java.util.stream.StreamSupport;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {

    @Test
    void create() {
        assertThat(Lotto.of().numbers().size()).isEqualTo(6);
    }

    @Test
    void createByString() {
        assertThatCode(() -> Lotto.of("1,2,3,4,5,6")).doesNotThrowAnyException();
    }

    @Test
    void checkDuplicateNumbers() {
        Lotto lotto = Lotto.of();
        long distinctNumberSize = StreamSupport.stream(lotto.numbers().spliterator(), false)
            .distinct()
            .count();

        assertThat(distinctNumberSize).isEqualTo(lotto.numbers().size());
    }

    @Test
    void equals() {
        Lotto lottoA = Lotto.of(new NoShuffleStrategy());
        Lotto lottoB = Lotto.of(new NoShuffleStrategy());

        assertThat(lottoA).usingRecursiveComparison().isEqualTo(lottoB);
    }

    @Test
    @DisplayName("당첨등수 조회")
    void winning() {
        Lotto lotto = Lotto.of(new NoShuffleStrategy());

        assertThat(lotto.winning(WinningNumbers.of(Arrays.asList(1, 2, 3, 4, 5, 6), 7))).isEqualTo(Winning.FIRST);
        assertThat(lotto.winning(WinningNumbers.of(Arrays.asList(1, 2, 3, 4, 5, 7), 6))).isEqualTo(Winning.SECOND);
        assertThat(lotto.winning(WinningNumbers.of(Arrays.asList(1, 2, 3, 4, 5, 7), 8))).isEqualTo(Winning.THIRD);
        assertThat(lotto.winning(WinningNumbers.of(Arrays.asList(1, 2, 3, 4, 7, 8), 9))).isEqualTo(Winning.FOURTH);
        assertThat(lotto.winning(WinningNumbers.of(Arrays.asList(1, 2, 3, 7, 8, 9), 10))).isEqualTo(Winning.FIFTH);
        assertThat(lotto.winning(WinningNumbers.of(Arrays.asList(1, 2, 7, 8, 9, 10), 11))).isEqualTo(Winning.LOSING);
        assertThat(lotto.winning(WinningNumbers.of(Arrays.asList(1, 7, 8, 9, 10, 11), 12))).isEqualTo(Winning.LOSING);
        assertThat(lotto.winning(WinningNumbers.of(Arrays.asList(7, 8, 9, 10, 11, 12), 13))).isEqualTo(Winning.LOSING);
    }

    @Test
    @DisplayName("당첨금 조회")
    void prize() {
        Lotto lotto = Lotto.of(new NoShuffleStrategy());

        assertThat(lotto.prize(WinningNumbers.of(Arrays.asList(1, 2, 3, 4, 5, 6), 7)))
            .isEqualTo(Winning.FIRST.amount());
        assertThat(lotto.prize(WinningNumbers.of(Arrays.asList(1, 2, 3, 4, 5, 7), 6)))
            .isEqualTo(Winning.SECOND.amount());
        assertThat(lotto.prize(WinningNumbers.of(Arrays.asList(1, 2, 3, 4, 5, 7), 8)))
            .isEqualTo(Winning.THIRD.amount());
        assertThat(lotto.prize(WinningNumbers.of(Arrays.asList(1, 2, 3, 4, 7, 8), 9)))
            .isEqualTo(Winning.FOURTH.amount());
        assertThat(lotto.prize(WinningNumbers.of(Arrays.asList(1, 2, 3, 7, 8, 9), 10)))
            .isEqualTo(Winning.FIFTH.amount());
        assertThat(lotto.prize(WinningNumbers.of(Arrays.asList(1, 2, 7, 8, 9, 10), 11)))
            .isEqualTo(Winning.LOSING.amount());
        assertThat(lotto.prize(WinningNumbers.of(Arrays.asList(1, 7, 8, 9, 10, 11), 12)))
            .isEqualTo(Winning.LOSING.amount());
        assertThat(lotto.prize(WinningNumbers.of(Arrays.asList(7, 8, 9, 10, 11, 12), 13)))
            .isEqualTo(Winning.LOSING.amount());
    }
}
