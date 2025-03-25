package lotto.domain;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoTest {
    @Test
    @DisplayName("로또 번호가 올바르게 생성되는지 테스트")
    void createLottoWithValidNumbers() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(numbers);

        assertThat(lotto.getLottoNumbers())
            .containsExactly(1, 2, 3, 4, 5, 6);
    }

    @Test
    @DisplayName("로또 번호가 정렬되어 반환되는지 테스트")
    void lottoNumbersShouldBeSorted() {
        List<Integer> numbers = Arrays.asList(6, 1, 3, 5, 4, 2);
        Lotto lotto = new Lotto(numbers);

        assertThat(lotto.getLottoNumbers())
            .isSorted()
            .containsExactly(1, 2, 3, 4, 5, 6);
    }

    @Test
    @DisplayName("로또 번호가 6개가 아닐 경우 예외 발생 테스트")
    void createLottoWithInvalidNumberOfNumbers() {
        List<Integer> invalidNumbers = Arrays.asList(1, 2, 3, 4, 5);

        assertThatIllegalArgumentException().isThrownBy(() -> new Lotto(invalidNumbers))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 번호가 1부터 45 사이의 숫자가 아닐 경우 예외 발생 테스트")
    void createLottoWithInvalidNumberRange() {
        List<Integer> invalidNumbers = Arrays.asList(1, 2, 3, 4, 5, 46);

        assertThatIllegalArgumentException().isThrownBy(() -> new Lotto(invalidNumbers))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 번호에 중복된 숫자가 있을 경우 예외 발생 테스트")
    void createLottoWithDuplicateNumbers() {
        List<Integer> duplicateNumbers = Arrays.asList(1, 2, 3, 4, 5, 5);

        assertThatIllegalArgumentException().isThrownBy(() -> new Lotto(duplicateNumbers))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
