package lotto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoTest {
    
    @Test
    void 로또_번호가_6개가_아닌_경우_예외를_발생시킨다() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Lotto.validate(List.of(1, 2, 3, 4, 5));
        });
    }
    
    @ParameterizedTest
    @ValueSource(ints = {0, 46, 100} )
    void 로또_번호가_1부터_45_사이의_숫자가_아닌_경우_예외를_발생시킨다(int number) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Lotto.validate(List.of(number, 2, 3, 4, 5, 6));
        });
    }

    @Test
    void 로또_번호에_중복된_번호가_있으면_예외를_발생시킨다() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Lotto.validate(List.of(1, 2, 3, 4, 5, 5));
        });
    }
    
    @Test
    void 로또_번호는_오름차순으로_정렬된다() {
        Lotto lotto = new Lotto(List.of(5, 3, 1, 4, 2, 6));

        assertThat(lotto.numbers()).containsExactly(1, 2, 3, 4, 5, 6);
    }
}
