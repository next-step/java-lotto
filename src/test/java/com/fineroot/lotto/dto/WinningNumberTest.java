package com.fineroot.lotto.dto;

import static org.assertj.core.api.Assertions.assertThat;

import com.fineroot.lotto.entity.LottoNumber;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningNumberTest {
    @Test
    @DisplayName("생성 확인")
    void create() {
        WinningNumber winningNumber1 = WinningNumber.from("1, 2, 3, 4, 5, 6");
        WinningNumber winningNumber2 = WinningNumber.defaultCreate();

        assertThat(winningNumber1.getLottoNumbers()).containsAll(Stream.of(1,2,3,4,5,6).map(LottoNumber::from).collect(
                Collectors.toList()));
        assertThat(winningNumber2.getLottoNumbers()).containsAll(Stream.of(1,1,1,1,1,1).map(LottoNumber::from).collect(
                Collectors.toList()));
    }
}
