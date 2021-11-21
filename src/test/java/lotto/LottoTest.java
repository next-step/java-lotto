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
        listOfArguments.add(Arguments.of(Arrays.asList(new Number(1), new Number(2), new Number(3), new Number(4), new Number(5), new Number(6)), 6));
        listOfArguments.add(Arguments.of(Arrays.asList(new Number(1), new Number(2), new Number(3), new Number(7), new Number(8), new Number(9)), 3));
        listOfArguments.add(Arguments.of(Arrays.asList(new Number(11), new Number(12), new Number(13), new Number(14), new Number(5), new Number(6)), 2));
        listOfArguments.add(Arguments.of(Arrays.asList(new Number(21), new Number(2), new Number(33), new Number(4), new Number(5), new Number(6)), 4));
        listOfArguments.add(Arguments.of(Arrays.asList(new Number(1), new Number(2), new Number(3), new Number(6), new Number(5), new Number(16)), 5));
        listOfArguments.add(Arguments.of(Arrays.asList(new Number(16), new Number(25), new Number(43), new Number(24), new Number(15), new Number(6)), 1));
        listOfArguments.add(Arguments.of(Arrays.asList(new Number(41), new Number(42), new Number(23), new Number(34), new Number(35), new Number(36)), 0));
        return listOfArguments.stream();
    }

    @ParameterizedTest
    @MethodSource("generateArgumentsStream")
    @DisplayName("lotto 번호 matching 테스트")
    void checkMatchingTest(List<Number> list, int expect) {
        Lotto lotto = new Lotto(() -> Arrays.asList(new Number(1), new Number(2), new Number(3), new Number(4), new Number(5), new Number(6)));
        assertThat(lotto.checkMatching(list)).isEqualTo(expect);
    }

    @Test
    @DisplayName("입력된 lotto 길이가 SIZE 보다 클 때 exception 테스트")
    void sizeCheckTest() {
        assertThatThrownBy(() -> {
            Lotto lotto = new Lotto(() -> Arrays.asList(new Number(1), new Number(2), new Number(3), new Number(4), new Number(5), new Number(6), new Number(7)));
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining(SIZE + " 와 길이가 다른 Lotto 는 입력될 수 없습니다.");

        assertThatThrownBy(() -> {
            Lotto lotto = new Lotto(() -> Arrays.asList(new Number(3), new Number(4), new Number(5), new Number(6), new Number(7)));
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining(SIZE + " 와 길이가 다른 Lotto 는 입력될 수 없습니다.");
    }

    @Test
    @DisplayName("입력된 lotto 에 중복된 숫자가 있을 때 exception 테스트")
    void distinctCheckTest() {
        assertThatThrownBy(() -> {
            Lotto lotto = new Lotto(() -> Arrays.asList(new Number(1), new Number(2), new Number(3), new Number(4), new Number(6), new Number(6)));
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("로또에 중복된 숫자가 존재합니다.");
    }
}
