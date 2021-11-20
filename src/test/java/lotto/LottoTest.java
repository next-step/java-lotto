package lotto;

import lotto.domain.Number;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import lotto.domain.Lotto;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.*;
import static lotto.domain.Lotto.SIZE;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

public class LottoTest {
    private static Stream<Arguments> generateArgumentsStream() {
        List<Arguments> listOfArguments = new LinkedList<>();
        listOfArguments.add(Arguments.of(Arrays.asList(new Number(1), new Number(2), new Number(3), new Number(4), new Number(5), new Number(6)), new Number(6)));
//        listOfArguments.add(Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 7), 5));
//        listOfArguments.add(Arguments.of(Arrays.asList(1, 2, 3, 4, 7, 8), 4));
//        listOfArguments.add(Arguments.of(Arrays.asList(1, 2, 3, 9, 7, 8), 3));
//        listOfArguments.add(Arguments.of(Arrays.asList(20, 2, 3, 11, 13, 16), 2));
//        listOfArguments.add(Arguments.of(Arrays.asList(24, 22, 31, 42, 17, 3), 1));
//        listOfArguments.add(Arguments.of(Arrays.asList(31, 42, 43, 34, 27, 18), 0));
        return listOfArguments.stream();
    }
    @ParameterizedTest
    @MethodSource("generateArgumentsStream")
    @DisplayName("lotto 번호 matching 테스트")
    void checkMatchingTest(List<Number> list, Number expect) {
        Lotto lotto = new Lotto(() -> Arrays.asList(new Number(1), new Number(2), new Number(3), new Number(4), new Number(5), new Number(6)));
        assertThat(lotto.checkMatching(list)).isEqualTo(expect);
    }
//
//    @Test
//    @DisplayName("입력된 lotto 길이가 SIZE 보다 클 때 exception 테스트")
//    void sizeCheckTest() {
//        assertThatThrownBy(() -> {
//            Lotto lotto = new Lotto(() -> Arrays.asList(1, 2, 3, 4, 5, 6, 7));
//        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining(SIZE + " 와 길이가 다른 Lotto 는 입력될 수 없습니다.");
//
//        assertThatThrownBy(() -> {
//            Lotto lotto = new Lotto(() -> Arrays.asList(1, 2, 3, 4, 5));
//        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining(SIZE + " 와 길이가 다른 Lotto 는 입력될 수 없습니다.");
//    }
//
//    @Test
//    @DisplayName("입력된 lotto 에 중복된 숫자가 있을 때 exception 테스트")
//    void distinctCheckTest() {
//        assertThatThrownBy(() -> {
//            Lotto lotto = new Lotto(() -> Arrays.asList(1, 2, 3, 4, 6, 6));
//        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("로또에 중복된 숫자가 존재합니다.");
//    }
}
