package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LottoTest {

    @Test
    @DisplayName("로또 번호는 전부 다 달라야 한다")
    public void distinct() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Lotto.of(1, 1, 1, 2, 3, 4));
    }

    @Test
    @DisplayName("로또 번호가 6개가 아니면 예외가 난다")
    public void invalidLength() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Lotto.of(1, 2, 3, 4, 5));
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Lotto.of(1, 2, 3, 4, 5, 6, 7));

    }

    @ParameterizedTest
    @NullSource
    @DisplayName("로또 번호가 없으면 예외가 난다")
    public void nullOrEmpty(List<Integer> numbers) {
        assertThatNullPointerException()
                .isThrownBy(() -> new Lotto(numbers));
    }

    @Test
    @DisplayName("로또 번호는 항상 오름차순으로 정렬된 상태이다")
    public void sorted() {
        Lotto lotto = Lotto.of(6, 5, 4, 3, 2, 1);
        assertThat(lotto.numbers()).isSorted();
    }

    @ParameterizedTest
    @DisplayName("두 로또가 공통으로 포함하는 숫자의 개수를 반환할 수 있다")
    @ValueSource(ints = {0, 1, 2, 3, 4, 5, 6})
    public void common(int expected) {
        // given
        List<Integer> all = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);

        List<Integer> numbers = all.subList(0, Lotto.COUNT);

        int windowStart = Lotto.COUNT - expected;
        List<Integer> otherNumbers = all.subList(windowStart, windowStart + Lotto.COUNT);

        // when
        Lotto one = new Lotto(numbers);
        Lotto other = new Lotto(otherNumbers);

        // then
        int result = one.matches(other);
        assertThat(result).isEqualTo(expected);
    }

}