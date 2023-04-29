package lotto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class LottoTest {
    @Test
    void 로또_숫자의_개수가_6개가_아니면_오류가_발생한다() {
        assertThatThrownBy(() -> new Lotto(new int[]{}))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "{0}은 로또 숫자의 범위를 벗어나서 오류가 발생한다")
    @MethodSource("getInputFor_로또_숫자의_범위가_1에서_45_사이가_아니면_오류가_발생한다")
    void 로또_숫자의_범위가_1에서_45_사이가_아니면_오류가_발생한다(int[] input) {
        assertThatThrownBy(() -> new Lotto(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또는_만들어지면_오름차순으로_정렬된다() {
        assertThat(new Lotto(new int[]{4, 2, 5, 3, 6, 1}).getLottoNumbers())
                .containsExactly(1, 2, 3, 4, 5, 6);
    }

    @Test
    void 로또에_중복된_숫자가_있으면_오류가_발생한다() {
        assertThatThrownBy(() -> new Lotto(new int[]{1, 2, 3, 4, 5, 5}))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> getInputFor_로또_숫자의_범위가_1에서_45_사이가_아니면_오류가_발생한다() {
        return Stream.of(
                Arguments.arguments(new int[]{0, 2, 3, 4, 5, 6}),
                Arguments.arguments(new int[]{1, 2, 3, 4, 5, 46})
        );
    }
}
