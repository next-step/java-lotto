package com.lotto;

import com.lotto.domain.*;
import com.lotto.exception.LottoNumberOutOfBoundsException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

import static org.assertj.core.api.Assertions.*;

public class LottoWinningBonusNumberTest {
    @ParameterizedTest
    @ValueSource(ints = {1, 45})
    void 보너스번호생성(int number) {
        assertThat(LottoWinningBonusNumber.valueOf(number))
                .isEqualTo(LottoWinningBonusNumber.valueOf(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46})
    void 보너스번호생성_범위예외(int number) {
        assertThatThrownBy(() -> LottoWinningBonusNumber.valueOf(number))
                .isInstanceOf(LottoNumberOutOfBoundsException.class);
    }

    @Test
    void 담청번호에_보너스포함_확인() {
        LottoWinningNumbers lottoWinningNumbers = LottoWinningNumbers.createLottoWinningNumbers("1,2,3,4,5,6");

        assertThat(lottoWinningNumbers.contains(LottoNumber.valueOf(1))).isTrue();
        assertThat(lottoWinningNumbers.contains(LottoWinningBonusNumber.valueOf(1))).isTrue();
    }

    @Test
    void 로또담청_2등인경우_보너스까지맞는_경우() {
        Lotto lotto = new Lotto(new TreeSet<>(Arrays.asList(
                LottoNumber.valueOf(1), LottoNumber.valueOf(2), LottoNumber.valueOf(3),
                LottoNumber.valueOf(4), LottoNumber.valueOf(5), LottoNumber.valueOf(45))));

        LottoReward reward = LottoWinningNumbers.createLottoWinningNumbers("1,2,3,4,5,6")
                .reward(lotto, LottoWinningBonusNumber.valueOf(6));

        assertThat(reward).isEqualTo(LottoReward.SECOND_BONUS);
    }

    @Test
    void 로또담청_2등인경우_보너스는안맞는_경우() {
        Lotto lotto = new Lotto(new TreeSet<>(Arrays.asList(
                LottoNumber.valueOf(1), LottoNumber.valueOf(2), LottoNumber.valueOf(3),
                LottoNumber.valueOf(4), LottoNumber.valueOf(5), LottoNumber.valueOf(45))));

        LottoReward reward = LottoWinningNumbers.createLottoWinningNumbers("1,2,3,4,5,6")
                .reward(lotto, LottoWinningBonusNumber.valueOf(7));

        assertThat(reward).isEqualTo(LottoReward.SECOND);
    }
}
