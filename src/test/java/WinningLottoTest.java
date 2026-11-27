import domain.Lotto;
import domain.Rank;
import domain.WinningLotto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningLottoTest {


    @Test
    void 보너스_번호가_당첨_번호와_중복되면_예외가_발생한다() {
        assertThatThrownBy(() -> new WinningLotto(6, 1, 2, 3, 4, 5, 6))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @ParameterizedTest
    @CsvSource({
            "'1,2,3,4,5,6', FIRST",
            "'1,2,3,4,5,7', SECOND",
            "'1,2,3,4,5,8', THIRD",
            "'1,2,3,4,8,9', FOURTH",
            "'1,2,3,8,9,10', FIFTH",
            "'1,2,8,9,10,11', MISS",
    })
    void 일치_개수와_보너스_일치_여부로_등수를_판정한다(String numbers, Rank expected) {
        WinningLotto winningLotto = new WinningLotto(7, 1, 2, 3, 4, 5, 6);
        assertThat(winningLotto.match(new Lotto(numbers))).isEqualTo(expected);
    }

    @Test
    void 오_개_일치여도_보너스_번호가_다르면_삼등이다() {
        WinningLotto winningLotto = new WinningLotto(45, 1, 2, 3, 4, 5, 6);
        assertThat(winningLotto.match(new Lotto(1, 2, 3, 4, 5, 7))).isEqualTo(Rank.THIRD);
    }
}