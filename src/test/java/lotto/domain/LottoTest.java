package lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    private static final Lotto ONE_TO_SIX_LOTTO =
            new Lotto(List.of(1, 2, 3, 4, 5, 6));

    @ParameterizedTest(name = "로또는 중복 없이 1 ~ 45의 숫자 6개를 가진다.")
    @MethodSource("provideInvalidLottoNumbers")
    void validation(List<Integer> invalidNumbers) {
        assertThatThrownBy(() -> new Lotto(invalidNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<List<Integer>> provideInvalidLottoNumbers() {
        return Stream.of(
                List.of(1),
                List.of(1, 2, 3, 4, 5, 6, 7),
                List.of(0, 2, 3, 4, 5, 6),
                List.of(1, 2, 3, 4, 5, 46),
                List.of(1, 1, 2, 3, 4, 5)
        );
    }

    @Test
    void matchCount() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 7, 8, 9));

        assertThat(lotto.matchCount(ONE_TO_SIX_LOTTO)).isEqualTo(3);
    }

    @Test
    void contains() {
        assertThat(ONE_TO_SIX_LOTTO.contains(1)).isTrue();
        assertThat(ONE_TO_SIX_LOTTO.contains(7)).isFalse();
    }

    @Test
    void getNumbers() {
        assertThat(ONE_TO_SIX_LOTTO.getNumbers())
                .containsExactly(1, 2, 3, 4, 5, 6);
    }
}
