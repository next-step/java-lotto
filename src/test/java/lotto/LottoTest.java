package lotto;


import lotto.domain.Lotto;
import lotto.domain.LottoNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    @Test
    @DisplayName("로또 변경 불가능 테스트")
    void getBalls() {
        Lotto lotto = new Lotto(Set.of(1, 2, 3, 4, 5, 6));

        assertThatThrownBy(() -> lotto.getNumbers().add(50))
                .isInstanceOf(UnsupportedOperationException.class);
        assertThatThrownBy(() -> lotto.getNumbers().remove(0))
                .isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void validate_로또번호_6개() {
        Set<Integer> numbers = Set.of(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(numbers);
        assertThat(lotto.getNumbers().size()).isEqualTo(6);
    }

    @Test
    void validate_로또번호_6개_이외() {
        Set<Integer> numbers = Set.of(1, 2, 3, 4, 5, 6, 7);
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Lotto(numbers);
        });
    }

}