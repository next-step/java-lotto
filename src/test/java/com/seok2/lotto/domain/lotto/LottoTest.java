package com.seok2.lotto.domain.lotto;

import static org.assertj.core.api.Assertions.assertThat;

import com.seok2.lotto.domain.rank.Rank;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoTest {

    static Stream<Arguments> check() {
        LottoNumber containsBonus = LottoNumber.of(6);
        LottoNumber notContainsBonus = LottoNumber.of(45);
        Lotto lotto = Lotto.auto(1, 2, 3, 4, 5, 6);
        Lotto winning1 = Lotto.auto(1, 2, 3, 4, 5, 6);
        Lotto winning2 = Lotto.auto(1, 2, 3, 4, 5, 7);
        Lotto winning3 = Lotto.auto(1, 2, 3, 4, 7, 8);
        Lotto winning4 = Lotto.auto(1, 2, 3, 7, 8, 9);
        Lotto winning5 = Lotto.auto(1, 2, 7, 8, 9, 10);

        return Stream.of(
            Arguments.of(lotto, winning1, notContainsBonus, Rank.FIRST),
            Arguments.of(lotto, winning2, containsBonus, Rank.SECOND),
            Arguments.of(lotto, winning2, notContainsBonus, Rank.THIRD),
            Arguments.of(lotto, winning3, notContainsBonus, Rank.FOURTH),
            Arguments.of(lotto, winning4, notContainsBonus, Rank.FIFTH),
            Arguments.of(lotto, winning5, notContainsBonus, Rank.MISS)
        );
    }

    @ParameterizedTest
    @MethodSource("check")
    void check(Lotto lotto, Lotto winning, LottoNumber bonus, Rank expected) {
        assertThat(lotto.check(winning, bonus)).isEqualTo(expected);
    }

    @Test
    void contains() {
        Lotto lotto = Lotto.auto(1,2,3,4,5,6);
        assertThat(lotto.contains(1)).isTrue();
        assertThat(lotto.contains(7)).isFalse();
    }

    @Test
    void isAuto() {
        assertThat(Lotto.auto(1,2,3,4,5,6).isAuto()).isTrue();
        assertThat(Lotto.manual(1,2,3,4,5,6).isAuto()).isFalse();
    }
}