package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class NumbersTest {

    Numbers numbers;

    @DisplayName("Numbers 객체 생성 및 조회 테스트")
    @ParameterizedTest
    @MethodSource("createTestParams")
    public void Numbers_객체_생성(List<Integer> param) throws Exception {
        assertThat(new Numbers(param).getNextNumbers(param.size())).containsExactly(param.get(0), param.get(1));
    }

    static Stream<Arguments> createTestParams() throws Throwable {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2)),
                Arguments.of(Arrays.asList(3, 6)),
                Arguments.of(Arrays.asList(7, 8))
        );
    }

    @DisplayName("Numbers 요소 추가 테스트")
    @ParameterizedTest
    @MethodSource("addNumberParams")
    public void Numbers_요소_추가(List<Integer> param, int element) throws Exception {
        numbers = new Numbers(param);
        numbers.add(element);
        assertThat(numbers.size()).isEqualTo(param.size() + 1);
    }

    static Stream<Arguments> addNumberParams() throws Throwable {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2), 4),
                Arguments.of(Arrays.asList(3, 6), 12)
        );
    }

}
