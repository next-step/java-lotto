package lotto.domain;

import lotto.domain.exception.InvalidLottoNumberException;
import lotto.domain.exception.InvalidLottoSizeException;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class LottoTest {
    @Test
    void Set으로_로또_객체를_만들_수_있다() {
        Set<Integer> numbers = Set.of(1, 2, 3, 4, 5, 6);
        assertThat(new Lotto(numbers).getLottoNumberSet().containsAll(numbers)).isTrue();
    }

    @Test
    void 배열로_로또_객체를_만들_수_있다() {
        int[] numbers = {1, 2, 3, 4, 5, 6};
        Set<Integer> numberSet = Arrays.stream(numbers).boxed().collect(Collectors.toSet());
        assertThat(Lotto.from(numbers).getLottoNumberSet().containsAll(numberSet)).isTrue();
    }

    @Test
    void List로_로또_객체를_만들_수_있다() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        assertThat(Lotto.from(numbers).getLottoNumberSet().containsAll(numbers)).isTrue();
    }

    @Test
    void String으로_로또_객체를_만들_수_있다() {
        String numbers = "1, 2, 3, 4, 5, 6";
        Set<Integer> numberSet = Set.of(1, 2, 3, 4, 5, 6);
        assertThat(Lotto.from(numbers).getLottoNumberSet().containsAll(numberSet)).isTrue();
    }

    @ParameterizedTest(name = "{0}을 가지고 있는지에 대한 결과는 {1}이다.")
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:true", "5:true", "6:true", "7:false"}, delimiter = ':')
    void 특정_숫자를_갖고_있는지_확인할_수_있다(int number, boolean expected) {
        Set<Integer> numbers = Set.of(1, 2, 3, 4, 5, 6);
        AssertionsForClassTypes.assertThat(new Lotto(numbers).hasNumber(number)).isEqualTo(expected);
    }

    @Test
    void 로또_숫자의_개수가_6개가_아니면_오류가_발생한다() {
        assertThatThrownBy(() -> new Lotto(Set.of()))
                .isInstanceOf(InvalidLottoSizeException.class);
    }

    @ParameterizedTest(name = "{0}은 로또 숫자의 범위를 벗어나서 오류가 발생한다")
    @MethodSource("getInputFor_로또_숫자의_범위가_1에서_45_사이가_아니면_오류가_발생한다")
    void 로또_숫자의_범위가_1에서_45_사이가_아니면_오류가_발생한다(int[] input) {
        assertThatThrownBy(() -> Lotto.from(input))
                .isInstanceOf(InvalidLottoNumberException.class);
    }

    @Test
    void 로또에_중복된_숫자가_있으면_오류가_발생한다() {
        assertThatThrownBy(() -> Lotto.from(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(InvalidLottoSizeException.class);
    }

    @Test
    void 이상한_문자열로_로또를_만들면_예외가_발생한다() {
        assertThatThrownBy(() -> Lotto.from("1, 2, 3, 4, 5, a")).isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> getInputFor_로또_숫자의_범위가_1에서_45_사이가_아니면_오류가_발생한다() {
        return Stream.of(
                Arguments.arguments(new int[]{0, 2, 3, 4, 5, 6}),
                Arguments.arguments(new int[]{1, 2, 3, 4, 5, 46})
        );
    }
}
