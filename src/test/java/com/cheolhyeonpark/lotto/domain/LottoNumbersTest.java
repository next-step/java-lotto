package com.cheolhyeonpark.lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class LottoNumbersTest {

    @Test
    public void countSameNumbersAsWinningNumber() {
        LottoNumbers lottoNumbers = new LottoNumbers(Arrays.asList(1, 2, 3, 7, 8, 9));
        List<Integer> winningNumber = Arrays.asList(1, 2, 3, 4, 5, 6);

        int count = lottoNumbers.countSameNumbersAs(winningNumber);

        assertThat(count).isEqualTo(3);
    }
}