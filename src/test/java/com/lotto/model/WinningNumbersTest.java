package com.lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class WinningNumbersTest {
    @DisplayName("잘못된 갯수를 입력받을 때 테스트")
    @Test
    public void wrongSizeTest() {
        //given
        Set<Integer> numbers = new HashSet<>();
        numbers.addAll(Arrays.asList(1, 2, 3, 4, 5, 6, 7));

        //then
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new WinningNumbers(numbers);
        });
    }

    @DisplayName("잘못된 값을 입력받을 때 테스트")
    @Test
    public void wrongNumberInputTest() {
        //given
        Set<Integer> numbers = new HashSet<>();
        numbers.addAll(Arrays.asList(1, 2, 3, 4, 5, 47));

        //then
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new WinningNumbers(numbers);
        });
    }

    @DisplayName("Lotto 갯수와 당첨 번호 확인 테스트")
    @Test
    public void checkCorrectCountTest() {
        //given
        Set<Integer> lottoNumbers = new HashSet<>();
        lottoNumbers.addAll(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto lotto = new Lotto(lottoNumbers);

        Set<Integer> winningNumberSet = new HashSet<>();
        winningNumberSet.addAll(Arrays.asList(1, 2, 3, 4, 5, 7));
        WinningNumbers winningNumbers = new WinningNumbers(winningNumberSet);

        //when
        int correctCount = winningNumbers.checkCorrectCount(lotto);

        //then
        assertThat(correctCount).isEqualTo(5);
    }


}
