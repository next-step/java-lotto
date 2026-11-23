import domain.Lotto;
import domain.WinningNumber;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {


    @Test
    void 번호에_45_초과_숫자가_포함되면_예외가_발생한다() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 46);
        Assertions.assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 번호에_1_미만의_숫자가_포함되면_예외가_발생한다() {
        List<Integer> numbers = List.of(0, 2, 3, 4, 5, 6);
        Assertions.assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 번호가_6개를_초과하면_예외가_발생한다() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7);
        Assertions.assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 번호가_6개_미만이면_예외가_발생한다() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        Assertions.assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 번호에_중복이_있으면_예외가_발생한다() {
        List<Integer> numbers = List.of(1, 1, 2, 3, 4, 5);
        Assertions.assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @Test
    void 받은_번호를_그대로_보관한다() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(lotto.getNumbers()).containsExactly(1, 2, 3, 4, 5, 6);
    }


    @Test
    void 자동_생성_로또는_1부터_45사이의_중복없는_6개_번호를_오름차순으로_가진다() {
        Lotto lotto = new Lotto();
        assertThat(lotto.getNumbers())
                .hasSize(6)
                .doesNotHaveDuplicates()
                .allMatch(n -> n >= 1 && n <= 45)
                .isSorted();
    }


    @Test
    void 당첨_번호와_일치하는_개수를_반환한다() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningNumber winningNumber = new WinningNumber(List.of(1, 2, 3, 10, 11, 12));

        assertThat(lotto.match(winningNumber)).isEqualTo(3);
    }

}
