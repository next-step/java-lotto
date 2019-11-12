package com.lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class WinnigLottoTest {

    @ParameterizedTest
    @ValueSource(strings = {"1, 2, 3, 4, 5, 6"})
    @DisplayName("당첨로또 생성 테스트")
    void inputWinnigLottoTest(String inputValue) {
        assertThat(WinningLotto.ofComma(inputValue)).isEqualTo(new WinningLotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1, 2, 3, 4, 4, 6"})
    @DisplayName("중복 당첨로또 테스트")
    void duplicateTest(String inputValue) {
        assertThatIllegalArgumentException().isThrownBy(() -> WinningLotto.ofComma(inputValue));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1, 2, 3, 4, 5, 6, 7"})
    @DisplayName("당첨로또 개수 테스트")
    void countTest(String inputValue) {
        assertThatIllegalArgumentException().isThrownBy(() -> WinningLotto.ofComma(inputValue));
    }
}
