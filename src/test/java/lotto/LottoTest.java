package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoTest {

    @DisplayName("로또를 생성한다")
    @Test
    void createLotto() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(lotto).isNotNull();
    }

    @DisplayName("로또 번호는 6개여야 한다")
    @ParameterizedTest
    @MethodSource("invalidLottoSizes")
    void validLottoSize(List<Integer> numbers) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Lotto(numbers))
                .withMessageContaining("6개");
    }

    @DisplayName("로또 번호는 1~45 사이의 숫자로 구성된다")
    @ParameterizedTest
    @MethodSource("invalidLottoNumberRange")
    void validLottoNumberRange(List<Integer> numbers) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Lotto(numbers))
                .withMessageContaining("1~45");
    }

    @DisplayName("로또 번호는 중복될 수 없다")
    @Test
    void validateNoDuplicates() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Lotto(List.of(1, 1, 2, 3, 4, 5)))
                .withMessageContaining("중복");
    }

    @DisplayName("로또 번호는 정렬된다")
    @Test
    void sortLottoNumbers() {
        Lotto lotto = new Lotto(List.of(2, 5, 8, 1, 3, 4));
        List<Integer> expected = List.of(1, 2, 3, 4, 5, 8);
        assertThat(lotto.numbers()).isEqualTo(expected);
    }

    static Stream<List<Integer>> invalidLottoSizes() {
        return Stream.of(
                List.of(),
                List.of(1, 2, 3, 4, 5),
                List.of(1, 2, 3, 4, 5, 6, 7)
        );
    }

    static Stream<List<Integer>> invalidLottoNumberRange() {
        return Stream.of(
                List.of(-1, 2, 3, 4, 5, 6),
                List.of(0, 2, 3, 4, 5, 6),
                List.of(1, 2, 3, 4, 5, 46)
        );
    }

}
