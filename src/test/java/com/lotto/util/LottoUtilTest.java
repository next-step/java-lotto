package com.lotto.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoUtilTest {
    @DisplayName("Lotto Number 추출 테스트")
    @Test
    public void extractLottoNumberTest() {
        //when
        Set<Integer> numbers = LottoUtil.extractRandomLottoNumbers();

        //then
        assertThat(numbers.size()).isEqualTo(6);
    }

}
