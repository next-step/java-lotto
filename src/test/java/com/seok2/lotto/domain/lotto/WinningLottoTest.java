package com.seok2.lotto.domain.lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.seok2.lotto.domain.lotto.Lotto;
import com.seok2.lotto.domain.lotto.LottoNumber;
import com.seok2.lotto.domain.lotto.WinningLotto;
import com.seok2.lotto.domain.rank.Rank;
import com.seok2.lotto.exception.LottoDuplicateNumberException;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class WinningLottoTest {

    static Stream<Arguments> check() {
        WinningLotto winning = WinningLotto.of(Lotto.auto(1, 2, 3, 4, 5, 6), LottoNumber.of(7));
        return Stream.of(
            Arguments.of(winning, Lotto.auto(1, 2, 3, 4, 5, 6), Rank.FIRST),
            Arguments.of(winning, Lotto.auto(1, 2, 3, 4, 5, 7), Rank.SECOND),
            Arguments.of(winning, Lotto.auto(1, 2, 3, 4, 5, 8), Rank.THIRD),
            Arguments.of(winning, Lotto.auto(1, 2, 3, 4, 8, 9), Rank.FOURTH),
            Arguments.of(winning, Lotto.auto(1, 2, 3, 8, 9, 10), Rank.FIFTH),
            Arguments.of(winning, Lotto.auto(1, 2, 8, 9, 10, 11), Rank.MISS)
        );
    }

    @Test
    void throwLottoDuplicateNumberException() {
        assertThatThrownBy(() -> WinningLotto.of(Lotto.auto(1, 2, 3, 4, 5, 6), LottoNumber.of(6)))
            .isInstanceOf(LottoDuplicateNumberException.class);
    }

    @Test
    void contains() {
        assertThat(Lotto.auto(1, 2, 3, 4, 5, 6).contains(LottoNumber.of(1))).isTrue();
        assertThat(Lotto.auto(1, 2, 3, 4, 5, 6).contains(LottoNumber.of(10))).isFalse();
    }

    @ParameterizedTest
    @MethodSource("check")
    void check(WinningLotto winning, Lotto lotto, Rank expected) {
        assertThat(winning.check(lotto)).isEqualTo(expected);
    }
}