package com.nextstep.lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoTest {
    @DisplayName("로또 숫자가 6개가 아닐 경우 예외처리")
    @Test
    void lotto() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Lotto(Arrays.asList(1,2,3,4,5)));
    }

    @DisplayName("로또 당첨 확인")
    @ParameterizedTest
    @MethodSource
    void getWinning(Lotto lotto, LottoWinning expected) {
        Lotto winningLotto = new Lotto(Arrays.asList(1,2,3,4,5,6));

        LottoWinning lottoWinning = lotto.getWinning(winningLotto);
        assertThat(lottoWinning).isEqualTo(expected);

    }

    private static Stream<Arguments> getWinning() {
        return Stream.of(
                Arguments.of(new Lotto(Arrays.asList(1,2,3,4,5,6)), LottoWinning.WIN_1ST),
                Arguments.of(new Lotto(Arrays.asList(11,2,3,4,5,6)), LottoWinning.WIN_3RD),
                Arguments.of(new Lotto(Arrays.asList(11,12,3,4,5,6)), LottoWinning.WIN_4TH),
                Arguments.of(new Lotto(Arrays.asList(11,12,13,4,5,6)), LottoWinning.WIN_5TH),
                Arguments.of(new Lotto(Arrays.asList(11,12,13,14,5,6)), LottoWinning.RETIRE)
        );
    }
}