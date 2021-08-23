package com.lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

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

    @DisplayName("Lotto 갯수보다 적은 수가 넘어 올 시 테스트")
    @Test
    public void lackNumbersTest() {
        //given
        Set<Integer> lottoNumbers = new HashSet<>();
        lottoNumbers.addAll(Arrays.asList(1, 2, 3, 4, 5));

        //then
        assertThatIllegalArgumentException().isThrownBy(() -> new Lotto(lottoNumbers));
    }

    @DisplayName("Lotto 행운 숫자 보유 여부 테스트")
    @ParameterizedTest
    @CsvSource({"1, true", "7, false"})
    public void havingBonusNumberTest(int bonusNumber, boolean expected) {
        //given
        Set<Integer> lottoNumbers = new HashSet<>();
        lottoNumbers.addAll(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto lotto = new Lotto(lottoNumbers);

        //when
        boolean actual = lotto.havingBonusNumber(bonusNumber);

        //then
        assertThat(actual).isEqualTo(expected);
    }
}
