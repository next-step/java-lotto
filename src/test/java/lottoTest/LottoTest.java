package lottoTest;

import lotto.Lotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoTest {

    @ParameterizedTest(name = "{1} 로또는 {1} 값을 리스트 반환")
    @MethodSource("generateLotto")
    void lottoGetNumbersTest(Lotto lotto, List<Integer> numbers) {
        Assertions.assertThat(lotto.getNumbers()).isEqualTo(numbers);
    }

    @ParameterizedTest(name = "lotto의 숫자 리스트 사이즈는 6")
    @MethodSource("generateLotto")
    void lottoListSizeTest(Lotto lotto) {
        Assertions.assertThat(lotto.getNumbers().size()).isEqualTo(6);
    }

    private static Stream<Arguments> generateLotto() {
        return Stream.of(
                Arguments.arguments(givenLotto(givenNumbers(1, 2, 3, 4, 5, 6)), givenNumbers(1, 2, 3, 4, 5, 6)),
                Arguments.arguments(givenLotto(givenNumbers(2, 3, 4, 5, 6, 7)), givenNumbers(2, 3, 4, 5, 6, 7)),
                Arguments.arguments(givenLotto(givenNumbers(3, 4, 5, 6, 7, 8)), givenNumbers(3, 4, 5, 6, 7, 8)),
                Arguments.arguments(givenLotto(givenNumbers(4, 5, 6, 7, 8, 9)), givenNumbers(4, 5, 6, 7, 8, 9)),
                Arguments.arguments(givenLotto(givenNumbers(5, 6, 7, 8, 9, 10)), givenNumbers(5, 6, 7, 8, 9, 10))
        );
    }

    private static Lotto givenLotto(List<Integer> integers) {
        return new Lotto(integers);
    }

    private static List<Integer> givenNumbers(int... numbers) {
        return Arrays.stream(numbers)
                .mapToObj(Integer::new)
                .collect(Collectors.toList());
    }
}
