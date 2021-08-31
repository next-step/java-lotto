package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class WinningNumberTest {
    WinningNumber winningNumber;
    List<Integer> winningNumberList;
    int bonusNumber;

    @BeforeEach
    void setup() {
        winningNumberList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        bonusNumber = 7;
        winningNumber = new WinningNumber(winningNumberList, bonusNumber);
    }

    @Test
    void create_WinningNumber_객체_생성() {

        assertThat(winningNumber).isEqualTo(new WinningNumber(Arrays.asList(1, 2, 3, 4, 5, 6), 7));
    }

    @Test
    void invalid_bonusNumber가_winningNumber와_겹치면_throw_Exception() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    new WinningNumber(Arrays.asList(1, 2, 3, 4, 5, 6), 6);
                });
    }

    @Test
    void checkLottoPrize_하나의_lotto의_당첨_등급을_반환() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7));

        // 2등
//        assertThat(winningNumber.checkLottoPrize(lotto)).isEqualTo(Prize.SECOND);
    }
}
