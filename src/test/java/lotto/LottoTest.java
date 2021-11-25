package lotto;

import lotto.domain.LottoNumber;
import lotto.domain.WinningLotto;
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
        listOfArguments.add(Arguments.of(new WinningLotto("1,2,3,4,5,6"), 6));
        listOfArguments.add(Arguments.of(new WinningLotto("1,2,13,14,15,6"), 3));
        listOfArguments.add(Arguments.of(new WinningLotto("12,13,14,5,6,7"), 2));
        listOfArguments.add(Arguments.of(new WinningLotto("1,2,3,4,8,9"), 4));
        listOfArguments.add(Arguments.of(new WinningLotto("1,2,4,7,6,3"), 5));
        listOfArguments.add(Arguments.of(new WinningLotto("11,12,13,14,15,6"), 1));
        listOfArguments.add(Arguments.of(new WinningLotto("14,15,25,35,45,33"), 0));
        return listOfArguments.stream();
    }

    @ParameterizedTest
    @MethodSource("generateArgumentsStream")
    @DisplayName("lotto 번호 matching 테스트")
    void checkMatchingTest(WinningLotto winningLotto, int expect) {
        Lotto lotto = new Lotto(() -> Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)));
        assertThat(lotto.checkMatching(winningLotto)).isEqualTo(expect);
    }

    @Test
    @DisplayName("입력된 lotto 길이가 SIZE 보다 클 때 exception 테스트")
    void sizeCheckTest() {
        assertThatThrownBy(() -> {
            Lotto lotto = new Lotto(() -> Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6), new LottoNumber(7)));
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining(SIZE + " 와 길이가 다른 Lotto 는 입력될 수 없습니다.");

        assertThatThrownBy(() -> {
            Lotto lotto = new Lotto(() -> Arrays.asList(new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6), new LottoNumber(7)));
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining(SIZE + " 와 길이가 다른 Lotto 는 입력될 수 없습니다.");
    }

    @Test
    @DisplayName("입력된 lotto 에 중복된 숫자가 있을 때 exception 테스트")
    void distinctCheckTest() {
        assertThatThrownBy(() -> {
            Lotto lotto = new Lotto(() -> Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(6), new LottoNumber(6)));
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("로또에 중복된 숫자가 존재합니다.");
    }
}
