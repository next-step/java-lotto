package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

class LottoTest {

    @DisplayName("로또 번호는 6개")
    @Test
    void createTest() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        assertThat(lotto.getNumbers()).hasSize(6);
    }

    @DisplayName("로또 자동 생성")
    @Test
    void createFromGeneratorTEst() {
        NumberGenerator numberGenerator = () -> List.of(3, 1, 5, 23, 44, 12);

        Lotto lotto = Lotto.createFrom(numberGenerator);

        assertAll(
                () -> assertThat(lotto.getNumbers()).hasSize(6),
                () -> assertThat(lotto.getNumbers()).containsExactly(1, 3, 5, 12, 23, 44)
        );
    }

    @DisplayName("로또 번호가 6개가 아닐 경우 예외 발생")
    @Test
    void hasSixNumbersTest() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 중복될 경우 예외 발생")
    @Test
    void distinctNumbersTest() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호를 오름차순으로 확인")
    @Test
    void numbersAscendingTest() {
        Lotto lotto = new Lotto(List.of(10, 4, 20, 7, 34, 1));

        assertThat(lotto.getNumbers()).containsExactly(1, 4, 7, 10, 20, 34);
    }

    @DisplayName("당첨 번호와 일치하는 로또 번호의 개수")
    @Test
    void countSameNumbersTest() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 40, 41, 42));
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 5, 8, 10));

        long result = lotto.countSameNumbers(winningNumbers);

        assertThat(result).isEqualTo(3);
    }
}
