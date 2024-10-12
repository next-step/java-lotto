package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumbersTest {

    @Test
    void shuffle() {
        LottoNumbers defaultNumbers = new LottoNumbers();
        LottoNumbers shuffledNumbers = new LottoNumbers();

        shuffledNumbers.shuffle();

        assertThat(defaultNumbers.getNumbers()).isNotEqualTo(shuffledNumbers.getNumbers());
    }

    @Test
    @DisplayName("로또볼 변경 불가능 테스트")
    void getBalls() {
        LottoNumbers lottoNumbers = new LottoNumbers();

        assertThatThrownBy(() -> lottoNumbers.getNumbers().set(0, 10))
                .isInstanceOf(UnsupportedOperationException.class);
        assertThatThrownBy(() -> lottoNumbers.getNumbers().add(50))
                .isInstanceOf(UnsupportedOperationException.class);
        assertThatThrownBy(() -> lottoNumbers.getNumbers().remove(0))
                .isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void validate_로또번호범위_이내() {
        Set<Integer> numbers = Set.of(1, 10, 21, 31, 41, 45);
        Lotto lotto = new Lotto(numbers);
        assertThat(lotto.getNumbers().size()).isEqualTo(6);
    }

    @Test
    void validate_로또번호범위_이외() {
        Set<Integer> numbers = Set.of(1, 2, 3, 4, 5, 46);
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Lotto(numbers);
        });
    }
}
