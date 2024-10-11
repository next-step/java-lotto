package lotto;


import lotto.domain.Lotto;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoTest {

    @Test
    void validate_로또번호_6개() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(numbers);
        assertThat(lotto.getNumbers().size()).isEqualTo(6);
    }

    @Test
    void validate_로또번호_6개_이외() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7);
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Lotto(numbers);
        });
    }

    @Test
    void validate_로또번호범위_이내() {
        List<Integer> numbers = List.of(1, 10, 21, 31, 41, 45);
        Lotto lotto = new Lotto(numbers);
        assertThat(lotto.getNumbers().size()).isEqualTo(6);
    }

    @Test
    void validate_로또번호범위_이외() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 46);
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Lotto(numbers);
        });
    }

    @Test
    void validate_로또번호_중복아님() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(numbers);
        assertThat(lotto.getNumbers().size()).isEqualTo(6);
    }

    @Test
    void validate_중복() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 5);
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Lotto(numbers);
        });
    }

}