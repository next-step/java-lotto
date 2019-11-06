package com.seok2.lotto.domain;

import com.seok2.lotto.exception.MinimumLotteriesException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LottoMachineTest {

    static Stream<Arguments> buy() {
        return Stream.of(
                Arguments.of(Money.of(5_000), 5),
                Arguments.of(Money.of(1_500), 1),
                Arguments.of(Money.of(2_000), 2)
        );
    }

    @ParameterizedTest
    @MethodSource("buy")
    void buy(Money money, int expected) {
        assertThat(LottoMachine.buy(money, Papers.empty()).size()).isEqualTo(expected);
    }

    @Test
    void valid() {
        assertThatThrownBy(() -> LottoMachine.buy(Money.of(500), Papers.empty()))
            .isInstanceOf(MinimumLotteriesException.class);
    }
}