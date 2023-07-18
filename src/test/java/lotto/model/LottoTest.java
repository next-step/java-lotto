package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;

class LottoTest {

    @Test
    void 로또_객체_생성() {
        // given, when, then
        assertDoesNotThrow(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6)));
    }

    @Test
    void 로또_객체_생성시_번호_주입() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(numbers);

        // when & then
        assertThat(lotto.getNumbers())
                .isEqualTo(Stream.of(1, 2, 3, 4, 5, 6)
                        .map(LottoNumber::of)
                        .collect(Collectors.toUnmodifiableList()));
    }

    @Test
    void 로또_객체_생성시_번호_개수_6개_미만이면_실패() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);

        // when & then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new Lotto(numbers));
        assertThat(exception).hasMessage("로또는 6개의 번호를 가져야합니다.");
    }

    @Test
    void 로또_객체_생성시_번호_개수_6개_초과면_실패() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7);

        // when & then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new Lotto(numbers));
        assertThat(exception).hasMessage("로또는 6개의 번호를 가져야합니다.");
    }

    @Test
    void 로또_객체_생성시_번호_개수_중복시_실패() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 5);

        // when & then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new Lotto(numbers));
        assertThat(exception).hasMessage("로또 번호는 중복될 수 없습니다.");
    }
}
