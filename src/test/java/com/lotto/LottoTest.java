package com.lotto;

import com.lotto.domain.Lotto;
import com.lotto.domain.LottoNumber;
import com.lotto.domain.LottoReward;
import com.lotto.domain.LottoWinningNumbers;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.TreeSet;

public class LottoTest {
    @DisplayName("로또 보상금 확인 1등")
    @Test
    void reward_win() {
        LottoNumber number1 = new LottoNumber(1);
        LottoNumber number2 = new LottoNumber(2);
        LottoNumber number3 = new LottoNumber(3);
        LottoNumber number4 = new LottoNumber(4);
        LottoNumber number5 = new LottoNumber(5);
        LottoNumber number6 = new LottoNumber(6);
        Lotto lotto = new Lotto(new TreeSet<>(Arrays.asList(number1, number2, number3, number4, number5, number6)));

        LottoReward reward = lotto.reward(new LottoWinningNumbers(
                new HashSet<>(Arrays.asList(number1, number2, number3, number4, number5, number6))));

        Assertions.assertThat(reward).isEqualTo(LottoReward.SIX);
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

        LottoNumber number7 = new LottoNumber(7);
        LottoNumber number8 = new LottoNumber(8);
        LottoNumber number9 = new LottoNumber(9);
        LottoNumber number10 = new LottoNumber(10);
        LottoNumber number11 = new LottoNumber(11);
        LottoNumber number12 = new LottoNumber(12);
        LottoReward reward = lotto.reward(new LottoWinningNumbers(
                new HashSet<>(Arrays.asList(number7, number8, number9, number10, number11, number12))));

        Assertions.assertThat(reward).isEqualTo(LottoReward.NOTHING);
    }
}
