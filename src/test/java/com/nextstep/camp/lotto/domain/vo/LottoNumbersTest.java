package com.nextstep.camp.lotto.domain.vo;

import java.util.List;
import java.util.stream.Stream;

import com.nextstep.camp.lotto.domain.exception.LottoNumberDuplicatedException;
import com.nextstep.camp.lotto.domain.exception.LottoNumbersSizeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LottoNumbersTest {

    static Stream<List<Integer>> validNumbers() {
        return Stream.of(
            List.of(1, 2, 3, 4, 5, 6),
            List.of(10, 20, 30, 40, 41, 45)
        );
    }

    @ParameterizedTest(name = "{0}")
    @MethodSource("validNumbers")
    void create_valid_lotto_numbers(List<Integer> input) {
        LottoNumbers numbers = LottoNumbers.of(input);
        assertEquals(6, numbers.getNumbers().size());
    }

    static Stream<List<Integer>> sizeInvalidNumbers() {
        return Stream.of(
            List.of(1, 2, 3),
            List.of(1, 2, 3, 4, 5, 6, 7)
        );
    }

    @ParameterizedTest(name = "{0}")
    @MethodSource("sizeInvalidNumbers")
    @DisplayName("6개가 아닌 경우 예외 발생")
    void invalid_size_throws_exception(List<Integer> input) {
        assertThrows(LottoNumbersSizeException.class, () -> LottoNumbers.of(input));
    }

    static Stream<List<Integer>> duplicatedNumbers() {
        return Stream.of(
            List.of(1, 2, 3, 3, 4, 5),
            List.of(10, 20, 20, 30, 40, 50)
        );
    }

    @ParameterizedTest(name = "{0}")
    @MethodSource("duplicatedNumbers")
    @DisplayName("중복 숫자 입력 시 예외 발생")
    void duplicated_number_throws_exception(List<Integer> input) {
        assertThrows(LottoNumberDuplicatedException.class, () -> LottoNumbers.of(input));
    }

    static Stream<MatchTestCase> matchCases() {
        return Stream.of(
            new MatchTestCase(List.of(1, 2, 3, 4, 5, 6), List.of(4, 5, 6, 7, 8, 9), 3),
            new MatchTestCase(List.of(10, 20, 30, 40, 41, 42), List.of(1, 2, 3, 4, 5, 6), 0)
        );
    }

    @ParameterizedTest(name = "{0}")
    @MethodSource("matchCases")
    @DisplayName("두 LottoNumbers 사이의 일치 개수 계산")
    void count_matches_between_lotto_numbers(MatchTestCase testCase) {
        LottoNumbers a = LottoNumbers.of(testCase.getA());
        LottoNumbers b = LottoNumbers.of(testCase.getB());
        assertEquals(testCase.getExpectedMatchCount(), a.countMatch(b));
    }

    static class MatchTestCase {
        private final List<Integer> a;
        private final List<Integer> b;
        private final int expectedMatchCount;

        public MatchTestCase(List<Integer> a, List<Integer> b, int expectedMatchCount) {
            this.a = a;
            this.b = b;
            this.expectedMatchCount = expectedMatchCount;
        }

        public List<Integer> getA() {
            return a;
        }

        public List<Integer> getB() {
            return b;
        }

        public int getExpectedMatchCount() {
            return expectedMatchCount;
        }

        @Override
        public String toString() {
            return "MatchTestCase{" +
                "a=" + a +
                ", b=" + b +
                ", expectedMatchCount=" + expectedMatchCount +
                '}';
        }
    }
}
