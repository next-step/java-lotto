package com.fineroot.lotto.dto;

import static org.assertj.core.api.Assertions.assertThat;

import com.fineroot.lotto.domain.LottoNumber;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class WinningNumberTest {

    private WinningNumber winningNumber;

    @BeforeEach
    void setUp() {
        winningNumber = WinningNumber.from("1, 2, 3, 4, 5, 6");
    }

    @ParameterizedTest
    @DisplayName("생성 확인: from")
    @CsvSource({"1,true","7,false"})
    void from(int input,boolean expected) {
        assertThat(winningNumber.contains(LottoNumber.from(input))).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("생성 확인: create")
    @CsvSource({"1,true","7,false"})
    void create(int input,boolean expected) {
        assertThat(WinningNumber.defaultCreate().contains(LottoNumber.from(input))).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("포함 유무 체크")
    @CsvSource({"1,true","7,false"})
    void contains(int input, boolean expected) {
        WinningNumber winningNumber = WinningNumber.from("1, 2, 3, 4, 5, 6");
        assertThat(winningNumber.contains(LottoNumber.from(input))).isEqualTo(expected);
    }
}
