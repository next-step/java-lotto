package com.lotto;

import com.lotto.domain.*;
import com.lotto.exception.LottoNumberFormatException;
import com.lotto.exception.IllegalLottoCountException;
import com.lotto.exception.LottoNumberOutOfBoundsException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.TreeSet;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningLottoTest {
    @Test
    void createLottoWinningNumbers_성공() {
        LottoNumber number1 = LottoNumber.valueOf(1);
        LottoNumber number2 = LottoNumber.valueOf(2);
        LottoNumber number3 = LottoNumber.valueOf(3);
        LottoNumber number4 = LottoNumber.valueOf(4);
        LottoNumber number5 = LottoNumber.valueOf(5);
        LottoNumber number6 = LottoNumber.valueOf(6);
        LottoNumber number7 = LottoNumber.valueOf(7);
        WinningLotto winningLotto = WinningLotto.createWinningLotto("1,2,3,4,5,6");
        assertThat(winningLotto.contains(number1)).isTrue();
        assertThat(winningLotto.contains(number2)).isTrue();
        assertThat(winningLotto.contains(number3)).isTrue();
        assertThat(winningLotto.contains(number4)).isTrue();
        assertThat(winningLotto.contains(number5)).isTrue();
        assertThat(winningLotto.contains(number6)).isTrue();
        assertThat(winningLotto.contains(number7)).isFalse();
    }

    @Test
    void createLottoWinningNumbers_입력숫자개수_예외() {
        assertThatThrownBy(() -> WinningLotto.createWinningLotto("1,2,3,4,5"))
                .isInstanceOf(IllegalLottoCountException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"asd", ""})
    void createLottoWinningNumbers_잘못된입력데이터_예외(String input) {
        assertThatThrownBy(() -> WinningLotto.createWinningLotto(input))
                .isInstanceOf(LottoNumberFormatException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1,-2,-3,-4,-5,-6"})
    void createLottoWinningNumbers_잘못된입력데이터_음수_예외(String input) {
        assertThatThrownBy(() -> WinningLotto.createWinningLotto(input))
                .isInstanceOf(LottoNumberOutOfBoundsException.class);
    }

    @DisplayName("로또 보상금 확인 1등")
    @Test
    void reward_성공() {
        WinningLotto winningLotto = WinningLotto.createWinningLotto("1,2,3,4,5,6");
        Lotto lotto = createLotto();

        LottoReward reward = winningLotto.reward(lotto);

        assertThat(reward).isEqualTo(LottoReward.FIRST);
    }

    @DisplayName("로또 보상금 확인 담청실패")
    @Test
    void reward_lose() {
        Lotto lotto = createLotto();

        WinningLotto winningLotto = WinningLotto.createWinningLotto("7,8,9,10,11,12");
        LottoReward reward = winningLotto.reward(lotto);

        Assertions.assertThat(reward).isEqualTo(LottoReward.MISS);
    }

    private Lotto createLotto() {
        LottoNumber number1 = LottoNumber.valueOf(1);
        LottoNumber number2 = LottoNumber.valueOf(2);
        LottoNumber number3 = LottoNumber.valueOf(3);
        LottoNumber number4 = LottoNumber.valueOf(4);
        LottoNumber number5 = LottoNumber.valueOf(5);
        LottoNumber number6 = LottoNumber.valueOf(6);
        return new Lotto(new TreeSet<>(Arrays.asList(number1, number2, number3, number4, number5, number6)));
    }

    @Test
    void 이등_보너스_보상() {
        Lotto lotto = createLotto();
        WinningLotto winningLotto = WinningLotto.createWinningLotto("1,2,3,4,5,7");
        winningLotto.setBonusNumber("7");

        LottoReward reward = winningLotto.reward(lotto);

        assertThat(reward).isEqualTo(LottoReward.SECOND_BONUS);
    }

    @Test
    void 이등_보너스없는_보상() {
        Lotto lotto = createLotto();
        WinningLotto winningLotto = WinningLotto.createWinningLotto("1,2,3,4,5,7");
        winningLotto.setBonusNumber("8");

        LottoReward reward = winningLotto.reward(lotto);

        assertThat(reward).isEqualTo(LottoReward.SECOND);
    }
}
