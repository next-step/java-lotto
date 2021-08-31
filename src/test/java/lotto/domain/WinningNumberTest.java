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
    Lotto lotto;

    @BeforeEach
    void setup() {
        winningNumberList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        bonusNumber = 7;
        winningNumber = new WinningNumber(winningNumberList, bonusNumber);
        lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
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
    void isMatchOfBonus_보너스번호랑_일치하는지_여부_반환() {
        assertThat(winningNumber.isMatchingBonus(lotto)).isFalse();
        assertThat(winningNumber.isMatchingBonus(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)))).isTrue();
    }

    @Test
    void checkLottoPrize_로또의_당첨_등수_반환() {
        // 1등
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(winningNumber.checkLottoPrize(lotto)).isEqualTo(Prize.FIRST);

        // 2등
        lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7));
        assertThat(winningNumber.checkLottoPrize(lotto)).isEqualTo(Prize.SECOND);

        // 당첨 없음
        lotto = new Lotto(Arrays.asList(45, 44, 43, 42, 2, 1));
        assertThat(winningNumber.checkLottoPrize(lotto)).isEqualTo(Prize.NONE);
    }
}
