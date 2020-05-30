package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class WinningLottoTest {
    private final static String DEFAULT_WINNING_NUMBER_TEXT = "1,2,3,4,5,6";

    @DisplayName("보너스번호가 당첨번호와 중복될 경우 IllegalArgument 예외가 발생한다.")
    @Test
    public void createWinningLottoContainBonusInLottoTest() {
        assertThatThrownBy(() -> {
            new WinningLotto(DEFAULT_WINNING_NUMBER_TEXT, 2);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("정상적인 파라메터를 입력할 경우 정상적으로 객체가 생성된다.")
    @Test
    public void createWinningLotto() {
        WinningLotto winningLotto = new WinningLotto(DEFAULT_WINNING_NUMBER_TEXT, 7);
        Lotto lotto = Lotto.valueOf(DEFAULT_WINNING_NUMBER_TEXT);
        assertThat(winningLotto).isNotNull();
        assertThat(winningLotto.inContainBonus(lotto)).isFalse();
        assertThat(winningLotto.getContainCount(lotto)).isEqualTo(6);
    }



}