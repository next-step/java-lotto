package com.lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
    @DisplayName("Lotto 갯수와 당첨 번호 확인 테스트")
    @Test
    public void checkCorrectCountTest() {
        //given
        Set<Integer> lottoNumbers = new HashSet<>();
        lottoNumbers.addAll(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto lotto = new Lotto(lottoNumbers);

        Set<Integer> winningNumberSet = new HashSet<>();
        winningNumberSet.addAll(Arrays.asList(1, 2, 3, 4, 5, 7));
        int bonusNumber = 45;
        WinningNumbers winningNumbers = new WinningNumbers(winningNumberSet, bonusNumber);

        //when
        int correctCount = lotto.countCorrectNumbers(winningNumbers.getNumbers());

        //then
        assertThat(correctCount).isEqualTo(5);
    }
}
