package lotto.step2;

import lotto.step2.domain.Numbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;

class NumbersTest {

    @Test
    @DisplayName("랜덤넘버 생성 - 6자리, 1~46, 중복값 x")
    void createNumbers() {
        List<Integer> numbers = new Numbers().getNumbers();
        assertThat(numbers).size().isEqualTo(6);
        assertThat(numbers).doesNotContain(47);
        assertThat(numbers).doesNotContain(0);
        assertThat(numbers.stream().distinct().collect(toList())).size().isEqualTo(6);
    }

    @ParameterizedTest
    @MethodSource("provideWiningNumbers")
    @DisplayName("당첨번호(provided)와 비교했을 때, 일치한 번호 개수(expected)")
    void getCountOfMatch(List<Integer> provided, int expected) {
        List<Integer> lottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Numbers numbers = new Numbers(lottoNumbers);
        assertThat(numbers.getCountOfMatch(provided)).isEqualTo(expected);
    }

    private static Stream<Arguments> provideWiningNumbers() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3, 35, 37, 26), 3),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 37, 26), 4),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 26), 5),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), 6)
        );
    }

}