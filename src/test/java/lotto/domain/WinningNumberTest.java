package lotto.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static lotto.domain.LottoNumbersTest.*;
import static org.assertj.core.api.Assertions.*;

class WinningNumberTest {

    private WinningNumber winningNumber;

    @BeforeEach
    void before() {
        winningNumber = new WinningNumber(createLottoNumber(1, 2, 3, 4, 5, 6), LottoNumber.valueOf(7));
    }
    @Test
    @DisplayName("containsCount 호출 시 주어진 LottoNumber와 비교하여 WinningNumber 포함 개수 반환")
    void containsCount() {
        Assertions.assertAll(
                () -> assertThat(winningNumber.containsCount(createLottoNumber(1, 2, 3, 10, 11, 12))).isEqualTo(3),
                () -> assertThat(winningNumber.containsCount(createLottoNumber(1, 2, 3, 4, 11, 12))).isEqualTo(4),
                () -> assertThat(winningNumber.containsCount(createLottoNumber(1, 2, 3, 4, 7, 12))).isEqualTo(4)
        );
    }

    @Test
    void isContainBonusNumber() {
        assertThat(winningNumber.isContainBonusNumber(createLottoNumber(1, 2, 3, 4, 5, 6))).isFalse();
        assertThat(winningNumber.isContainBonusNumber(createLottoNumber(1, 2, 3, 4, 5, 7))).isTrue();
    }
}