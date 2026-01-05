package lotto;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LottoTest {
    
    @Test
    void 로또_번호가_6개가_아닌_경우_예외를_발생시킨다() {
        assertThatThrownBy(() -> new Lotto(1, 2, 3, 4, 5))
                .isInstanceOf(IllegalArgumentException.class);
    }
    
    @Test
    void 로또_번호에_중복된_번호가_있으면_예외를_발생시킨다() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Lotto(1, 2, 3, 4, 5, 5);
        });
    }
    
    @Test
    void 로또_번호는_오름차순으로_정렬된다() {
        Lotto lotto = new Lotto(5, 3, 1, 4, 2, 6);

        List<Integer> numbers = lotto.numbers().stream()
                        .map(LottoNumber::value)
                        .toList();

        assertThat(numbers).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @Test
    void 로또_등수를_계산할_수_있다() {
        WinningLotto winningLotto = new WinningLotto(new Lotto(1, 2, 3, 4, 5, 6), 7);

        assertThat(new Lotto(1, 2, 3, 4, 5, 6).rank(winningLotto)).isEqualTo(LottoRank.FIRST);
        assertThat(new Lotto(1, 2, 3, 4, 5, 7).rank(winningLotto)).isEqualTo(LottoRank.SECOND);
        assertThat(new Lotto(1, 2, 3, 4, 5, 8).rank(winningLotto)).isEqualTo(LottoRank.THIRD);
    }
}
