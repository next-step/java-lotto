package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.*;

class LottoTest {

    @DisplayName("1부터 45 사이의 중복되지 않는 번호 6개로 로또를 만든다")
    @Test
    void createLotto() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 45));

        assertThat(lotto.getNumbers()).containsExactly(1, 2, 3, 4, 5, 45);
    }

    @DisplayName("번호가 6개가 아니면 예외가 발생한다")
    @ParameterizedTest(name = "{0}개")
    @ValueSource(ints = {5, 7})
    void invalidSize(int size) {
        assertThatThrownBy(() -> new Lotto(numbersOf(size)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("번호가 1보다 작으면 예외가 발생한다")
    @Test
    void tooSmallNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(0, 1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("번호가 45보다 크면 예외가 발생한다")
    @Test
    void tooLargeNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("번호가 중복되면 예외가 발생한다")
    @Test
    void duplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 1, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private List<Integer> numbersOf(int size) {
        return IntStream.rangeClosed(1, size).boxed().toList();
    }
}
