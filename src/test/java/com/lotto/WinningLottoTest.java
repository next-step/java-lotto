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
        Lotto lotto = Lotto.createLotto("1,2,3,4,5,6");
        String bonusNumber = "1";
        WinningLotto winningLotto = WinningLotto.createWinningLotto(lotto, bonusNumber);

        assertThat(winningLotto).isEqualTo(WinningLotto.createWinningLotto(lotto, bonusNumber));
    }

    @DisplayName("로또 보상금 확인 1등")
    @Test
    void reward_성공() {
        Lotto winningLottoNumbers = Lotto.createLotto("1,2,3,4,5,6");
        WinningLotto winningLotto = WinningLotto.createWinningLotto(winningLottoNumbers, "9");

        Lotto lotto = Lotto.createLotto("1,2,3,4,5,6");
        LottoReward reward = winningLotto.reward(lotto);

        assertThat(reward).isEqualTo(LottoReward.FIRST);
    }

    @DisplayName("로또 보상금 확인 담청실패")
    @Test
    void reward_lose() {
        Lotto winningLottoNumbers = Lotto.createLotto("1,2,3,4,5,6");
        WinningLotto winningLotto = WinningLotto.createWinningLotto(winningLottoNumbers, "9");

        Lotto lotto = Lotto.createLotto("7,8,9,10,11,12");
        LottoReward reward = winningLotto.reward(lotto);

        Assertions.assertThat(reward).isEqualTo(LottoReward.MISS);
    }

    @Test
    void 이등_보너스_보상() {
        Lotto winningLottoNumbers = Lotto.createLotto("1,2,3,4,5,6");
        WinningLotto winningLotto = WinningLotto.createWinningLotto(winningLottoNumbers, "6");

        Lotto lotto = Lotto.createLotto("1,2,3,4,5,7");

        LottoReward reward = winningLotto.reward(lotto);

        assertThat(reward).isEqualTo(LottoReward.SECOND_BONUS);
    }

    @Test
    void 이등_보너스없는_보상() {
        Lotto winningLottoNumbers = Lotto.createLotto("1,2,3,4,5,6");
        WinningLotto winningLotto = WinningLotto.createWinningLotto(winningLottoNumbers, "9");

        Lotto lotto = Lotto.createLotto("1,2,3,4,5,7");

        LottoReward reward = winningLotto.reward(lotto);

        assertThat(reward).isEqualTo(LottoReward.SECOND);
    }
}
