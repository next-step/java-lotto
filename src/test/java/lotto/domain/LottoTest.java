package lotto.domain;

import java.util.HashSet;
import java.util.Set;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import org.junit.jupiter.api.Test;

public class LottoTest {
    @Test
    void 생성_테스트() {
        Set<Integer> numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(3);
        numbers.add(5);
        numbers.add(6);
        numbers.add(7);
        numbers.add(8);

        assertThat(new Lotto(numbers)).isEqualTo(new Lotto(1, 3, 5, 6, 7, 8));
    }

    @Test
    void 생성_에러_테스트() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    Set<Integer> numbers = new HashSet<>();
                    numbers.add(1);
                    numbers.add(3);
                    numbers.add(5);
                    numbers.add(6);
                    numbers.add(7);

                    Lotto lotto = new Lotto(numbers);
                }).withMessageMatching("숫자 6개만 입력 가능합니다");
    }

    @Test
    void 우승숫자_테스트() {
        Set<Integer> winningNumbers = Set.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        assertThat(new Lotto(7, 8, 9, 10, 11, 12).hasWinningNumbers(winningNumbers, bonusNumber)).isEqualTo(LOTTO_REWARD.MISS);
        assertThat(new Lotto(1, 8, 9, 10, 11, 12).hasWinningNumbers(winningNumbers, bonusNumber)).isEqualTo(LOTTO_REWARD.MISS);
        assertThat(new Lotto(1, 2, 9, 10, 11, 12).hasWinningNumbers(winningNumbers, bonusNumber)).isEqualTo(LOTTO_REWARD.MISS);
        assertThat(new Lotto(1, 2, 3, 10, 11, 12).hasWinningNumbers(winningNumbers, bonusNumber)).isEqualTo(LOTTO_REWARD.FIFTH);
        assertThat(new Lotto(1, 2, 3, 4, 11, 12).hasWinningNumbers(winningNumbers, bonusNumber)).isEqualTo(LOTTO_REWARD.FOURTH);
        assertThat(new Lotto(1, 2, 3, 4, 5, 12).hasWinningNumbers(winningNumbers, bonusNumber)).isEqualTo(LOTTO_REWARD.THIRD);
        assertThat(new Lotto(1, 2, 3, 4, 5, 7).hasWinningNumbers(winningNumbers, bonusNumber)).isEqualTo(LOTTO_REWARD.SECOND);
        assertThat(new Lotto(1, 2, 3, 4, 5, 6).hasWinningNumbers(winningNumbers, bonusNumber)).isEqualTo(LOTTO_REWARD.FIRST);
    }
}
