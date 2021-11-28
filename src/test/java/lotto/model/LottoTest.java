package lotto.model;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

public class LottoTest {

    @DisplayName("lotto 번호와 당첨 번호가 주어졌을 때 일치하는 카운트를 반환하는지 검증")
    @ParameterizedTest
    @MethodSource("matchParameter")
    void matchTest(Lotto lotto, Lotto winningNnumber, int expected) {
        assertThat(lotto.getMachedCount(winningNnumber)).isEqualTo(expected);
    }

    private static Stream<Arguments> matchParameter() {
        List<Number> pickedNumbers = Arrays.asList(new Number(1),
                                                   new Number(2),
                                                   new Number(3),
                                                   new Number(4),
                                                   new Number(5),
                                                   new Number(6));

        return Stream.of(Arguments.of(new Lotto(pickedNumbers),
                                      new Lotto(Arrays.asList(new Number(1),
                                                              new Number(2),
                                                              new Number(3),
                                                              new Number(4),
                                                              new Number(5),
                                                              new Number(6))),
                                      6),
                         Arguments.of(new Lotto(pickedNumbers),
                                      new Lotto(Arrays.asList(new Number(1),
                                                              new Number(2),
                                                              new Number(3),
                                                              new Number(4),
                                                              new Number(5),
                                                              new Number(7))),
                                      5),
                         Arguments.of(new Lotto(pickedNumbers),
                                      new Lotto(Arrays.asList(new Number(1),
                                                              new Number(2),
                                                              new Number(3),
                                                              new Number(4),
                                                              new Number(9),
                                                              new Number(10))),
                                      4),
                         Arguments.of(new Lotto(pickedNumbers),
                                      new Lotto(Arrays.asList(new Number(1),
                                                              new Number(2),
                                                              new Number(3),
                                                              new Number(8),
                                                              new Number(9),
                                                              new Number(10))),
                                      3),
                         Arguments.of(new Lotto(pickedNumbers),
                                      new Lotto(Arrays.asList(new Number(36),
                                                              new Number(22),
                                                              new Number(15),
                                                              new Number(17),
                                                              new Number(26),
                                                              new Number(44))),
                                      0));
    }

    @DisplayName("Lotto와 bonus number가 주어졌을 때 해당 number를 포함하고 있는지 반환하는지 검증")
    @ParameterizedTest
    @CsvSource({ "3, true", "7, false" })
    void containsTest(int number, boolean expected) {
        Lotto lotto = new Lotto(
                Arrays.asList(new Number(1), new Number(2), new Number(3), new Number(4), new Number(5), new Number(6)));
        assertThat(lotto.contains(new Number(number))).isEqualTo(expected);
    }
}
