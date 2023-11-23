package com.fineroot.lotto.dto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.fineroot.lotto.domain.LottoNumber;
import com.fineroot.lotto.util.ExceptionMessage;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class WinningNumberSetTest {
    @Test
    @DisplayName("생성 확인")
    void of() {
        assertThat(WinningNumberSet.of("1,2,3,4,5,6", "7")).isInstanceOf(WinningNumberSet.class);
    }

    @Test
    @DisplayName("생성시 보너스 번호 중복 입력 예외 확인")
    void of_exception() {
        assertThatThrownBy(() -> WinningNumberSet.of("1,2,3,4,5,6", "6"))
                .hasMessageContaining(ExceptionMessage.BONUS_NUMBER_DUPLICATED.getMessage());
    }

    @ParameterizedTest
    @DisplayName("로또 번호 매칭 확인")
    @CsvSource({"1,true", "7,false"})
    void contains(int input, boolean expected) {
        assertThat(WinningNumberSet.of("1,2,3,4,5,6", "7").contains(LottoNumber.from(input)))
                .isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("로또 번호 매칭 확인")
    @CsvSource({"'1,2,3,4,5,7',true", "'1,2,3,4,5,6',false"})
    void matchBonus(String input, boolean expected) {
        assertThat(WinningNumberSet.of("1,2,3,4,5,6", "7").hasBonus(
                Arrays.stream(input.split(",")).map(Integer::parseInt).map(LottoNumber::from).collect(Collectors.toList())))
                .isEqualTo(expected);
    }
}
