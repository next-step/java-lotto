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

public class LottoWinningNumbersTest {
    @Test
    void createLottoWinningNumbers_성공() {
        LottoNumber number1 = new LottoNumber(1);
        LottoNumber number2 = new LottoNumber(2);
        LottoNumber number3 = new LottoNumber(3);
        LottoNumber number4 = new LottoNumber(4);
        LottoNumber number5 = new LottoNumber(5);
        LottoNumber number6 = new LottoNumber(6);
        LottoNumber number7 = new LottoNumber(7);
        LottoWinningNumbers lottoWinningNumbers = LottoWinningNumbers.createLottoWinningNumbers("1,2,3,4,5,6");
        assertThat(lottoWinningNumbers.contains(number1)).isTrue();
        assertThat(lottoWinningNumbers.contains(number2)).isTrue();
        assertThat(lottoWinningNumbers.contains(number3)).isTrue();
        assertThat(lottoWinningNumbers.contains(number4)).isTrue();
        assertThat(lottoWinningNumbers.contains(number5)).isTrue();
        assertThat(lottoWinningNumbers.contains(number6)).isTrue();
        assertThat(lottoWinningNumbers.contains(number7)).isFalse();
    }

    @Test
    void createLottoWinningNumbers_입력숫자개수_예외() {
        assertThatThrownBy(() -> LottoWinningNumbers.createLottoWinningNumbers("1,2,3,4,5"))
                .isInstanceOf(IllegalLottoCountException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"asd", ""})
    void createLottoWinningNumbers_잘못된입력데이터_예외(String input) {
        assertThatThrownBy(() -> LottoWinningNumbers.createLottoWinningNumbers(input))
                .isInstanceOf(LottoNumberFormatException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1,-2,-3,-4,-5,-6"})
    void createLottoWinningNumbers_잘못된입력데이터_음수_예외(String input) {
        assertThatThrownBy(() -> LottoWinningNumbers.createLottoWinningNumbers(input))
                .isInstanceOf(LottoNumberOutOfBoundsException.class);
    }

    @DisplayName("로또 보상금 확인 1등")
    @Test
    void reward_성공() {
        LottoWinningNumbers lottoWinningNumbers = LottoWinningNumbers.createLottoWinningNumbers("1,2,3,4,5,6");
        LottoNumber number1 = new LottoNumber(1);
        LottoNumber number2 = new LottoNumber(2);
        LottoNumber number3 = new LottoNumber(3);
        LottoNumber number4 = new LottoNumber(4);
        LottoNumber number5 = new LottoNumber(5);
        LottoNumber number6 = new LottoNumber(6);
        Lotto lotto = new Lotto(new TreeSet<>(Arrays.asList(number1, number2, number3, number4, number5, number6)));

        LottoReward reward = lottoWinningNumbers.reward(lotto, LottoWinningBonusNumber.valueOf(7));

        assertThat(reward).isEqualTo(LottoReward.FIRST);
    }

    @DisplayName("로또 보상금 확인 담청실패")
    @Test
    void reward_lose() {
        LottoNumber number1 = new LottoNumber(1);
        LottoNumber number2 = new LottoNumber(2);
        LottoNumber number3 = new LottoNumber(3);
        LottoNumber number4 = new LottoNumber(4);
        LottoNumber number5 = new LottoNumber(5);
        LottoNumber number6 = new LottoNumber(6);
        Lotto lotto = new Lotto(new TreeSet<>(Arrays.asList(number1, number2, number3, number4, number5, number6)));

        LottoWinningNumbers lottoWinningNumbers = LottoWinningNumbers.createLottoWinningNumbers("7,8,9,10,11,12");
        LottoReward reward = lottoWinningNumbers.reward(lotto, LottoWinningBonusNumber.valueOf(1));

        Assertions.assertThat(reward).isEqualTo(LottoReward.MISS);
    }
}
