package com.lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

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
            new WinningNumbers(numbers, 45);
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
            new WinningNumbers(numbers, 45);
        });
    }

    @DisplayName("보너스 번호를 잘못된 값을 입력 받았을 때 테스트")
    @Test
    public void wrongBonusNumberInputTest() {
        //given
        Set<Integer> numbers = new HashSet<>();
        numbers.addAll(Arrays.asList(1, 2, 3, 4, 5, 6));
        int bonusNumber = 47;

        //then
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new WinningNumbers(numbers, bonusNumber);
        });
    }

    @DisplayName("보너스 번호를 중복된 값을 입력 받았을 때 테스트")
    @Test
    public void duplicatedBonusNumberInputTest() {
        //given
        Set<Integer> numbers = new HashSet<>();
        numbers.addAll(Arrays.asList(1, 2, 3, 4, 5, 6));
        int bonusNumber = 6;

        //then
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new WinningNumbers(numbers, bonusNumber);
        });
    }


}
