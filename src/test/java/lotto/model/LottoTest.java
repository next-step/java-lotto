package lotto.model;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class LottoTest {

    @DisplayName("lotto 번호와 당첨 번호가 주어졌을 때 일치하는 카운트를 반환하는지 검증")
    @ParameterizedTest
    @MethodSource("matchParameter")
    void matchTest(Lotto lotto, Lotto winningNnumber, Number bonusNumber, Rank expected) {
        assertThat(lotto.match(winningNnumber, bonusNumber)).isEqualTo(expected);
    }

    private static Stream<Arguments> matchParameter() {
        List<Number> pickedNumbers = Arrays.asList(new Number(1),
                                                   new Number(2),
                                                   new Number(3),
                                                   new Number(4),
                                                   new Number(5),
                                                   new Number(6));
        Number bonusNumber = new Number(7);

        return Stream.of(Arguments.of(new Lotto(pickedNumbers),
                                      new Lotto(Arrays.asList(new Number(1),
                                                              new Number(2),
                                                              new Number(3),
                                                              new Number(4),
                                                              new Number(5),
                                                              new Number(6))),
                                      bonusNumber,
                                      Rank.FIRST),
                         Arguments.of(new Lotto(Arrays.asList(new Number(1),
                                                              new Number(2),
                                                              new Number(3),
                                                              new Number(4),
                                                              new Number(5),
                                                              new Number(7))),
                                      new Lotto(Arrays.asList(new Number(1),
                                                              new Number(2),
                                                              new Number(3),
                                                              new Number(4),
                                                              new Number(5),
                                                              new Number(6))),
                                      bonusNumber,
                                      Rank.SECOND),
                         Arguments.of(new Lotto(pickedNumbers),
                                      new Lotto(Arrays.asList(new Number(1),
                                                              new Number(2),
                                                              new Number(3),
                                                              new Number(4),
                                                              new Number(5),
                                                              new Number(8))),
                                      bonusNumber,
                                      Rank.THIRD),
                         Arguments.of(new Lotto(pickedNumbers),
                                      new Lotto(Arrays.asList(new Number(1),
                                                              new Number(2),
                                                              new Number(3),
                                                              new Number(4),
                                                              new Number(9),
                                                              new Number(10))),
                                      bonusNumber,
                                      Rank.FOURTH),
                         Arguments.of(new Lotto(pickedNumbers),
                                      new Lotto(Arrays.asList(new Number(1),
                                                              new Number(2),
                                                              new Number(3),
                                                              new Number(8),
                                                              new Number(9),
                                                              new Number(10))),
                                      bonusNumber,
                                      Rank.FIFTH),
                         Arguments.of(new Lotto(pickedNumbers),
                                      new Lotto(Arrays.asList(new Number(36),
                                                              new Number(22),
                                                              new Number(15),
                                                              new Number(17),
                                                              new Number(26),
                                                              new Number(44))),
                                      bonusNumber,
                                      Rank.MISS));
    }

    @DisplayName("로또 구매 가격이 주어졌을 때 몇 개의 로또를 구매했는지 반환하는 로직 검증")
    @Test
    void lottoCountByAmountTest() {
        int amount = 14_000;
        int expectedCount = 14;
        assertThat(Lotto.getLottoCount(amount)).isEqualTo(expectedCount);
    }
}
