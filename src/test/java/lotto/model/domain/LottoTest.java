package lotto.model.domain;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

class LottoTest {

    @Test
    void 로또_객체_생성() {
        assertThatNoException().isThrownBy(() -> Lotto.create(List.of(1, 2, 3, 4, 5, 6)));
    }

    @Test
    void 로또_객체_생성시_번호_주입() {
        // given
        final List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        final Lotto lotto = Lotto.create(numbers);

        // when & then
        assertThat(lotto.getNumbers())
                .isEqualTo(Stream.of(1, 2, 3, 4, 5, 6)
                        .map(LottoNumber::of)
                        .collect(Collectors.toUnmodifiableList()));
    }

    @Test
    void 로또_객체_생성시_번호_개수_6개_미만이면_실패() {
        // given
        final List<Integer> numbers = List.of(1, 2, 3, 4, 5);

        // when & then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Lotto.create(numbers));
    }

    @Test
    void 로또_객체_생성시_번호_개수_6개_초과면_실패() {
        // given
        final List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7);

        // when & then
        assertThatIllegalArgumentException().isThrownBy(() -> Lotto.create(numbers));
    }
}
