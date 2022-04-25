package me.devyonghee.lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.*;

@DisplayName("우승 로또 생성기")
class WinnerLottoGeneratorTest {

    @Test
    @DisplayName("객체화")
    void instance() {
        assertThatNoException().isThrownBy(() -> WinnerLottoGenerator.from(() -> Collections.singletonList("1")));
    }

    @Test
    @DisplayName("문자 제공자는 필수")
    void instance_nullStringsProvider_thrownNullPointerException() {
        assertThatNullPointerException().isThrownBy(() -> WinnerLottoGenerator.from(null));
    }

    @Test
    @DisplayName("우승 로또 생성")
    void lotto() {
        assertThat(WinnerLottoGenerator.from(() -> Arrays.asList("1", "2", "3", "4", "5", "6")).lotto())
                .isEqualTo(Lotto.from(LottoNumbers.from(
                        IntStream.rangeClosed(1, 6)
                                .mapToObj(LottoNumber::from)
                                .collect(Collectors.toList())
                )));
    }
}
