package com.seok2.lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.seok2.common.utils.StringUtils;
import com.seok2.lotto.exception.EmptyLotteriesException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class LotteriesTest {

    static Stream<List> throwEmptyLotteriesException() {
        return Stream.of(
            null,
            Collections.emptyList()
        );
    }

    @ParameterizedTest
    @MethodSource("throwEmptyLotteriesException")
    void throwEmptyLotteriesException(List<Lotto> lotteries) {
        assertThatThrownBy(() -> Lotteries.of(lotteries))
            .isInstanceOf(EmptyLotteriesException.class);

    }

    @Test
    void check() {
        Lotteries lotteries = Lotteries.of(Arrays.asList(Lotto.of(1,2,3,4,5,6),Lotto.of(1,2,3,7,8,9)));
        Ranks ranks = lotteries.check(WinningLotto.of(Lotto.of(1,2,3,10,11,12), LottoNumber.of(13)));
        assertThat(ranks.count(Rank.FIFTH)).isEqualTo(2);
    }
    @Test
    void sizeOfAuto() {
        Lotteries lotteries = Lotteries.of(Arrays.asList(Lotto.of(Auto.TRUE, 1,2,3,4,5,6),Lotto.of(Auto.FALSE,1,2,3,7,8,9)));
        assertThat(lotteries.sizeOfAuto()).isEqualTo(1);
    }
    @Test
    void sizeOfManual() {
        Lotteries lotteries = Lotteries.of(Arrays.asList(Lotto.of(Auto.TRUE, 1,2,3,4,5,6),Lotto.of(Auto.FALSE,1,2,3,7,8,9)));
        assertThat(lotteries.sizeOfManual()).isEqualTo(1);
    }
}