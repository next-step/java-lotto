package com.cheolhyeonpark.lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class LottoNumbersTest {

    @Test
    void testEquals() {
        LottoNumbers case1 = new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoNumbers case2 = new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoNumbers case3 = new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 1));

        assertThat(case1.equals(case2)).isTrue();
        assertThat(case1.equals(case3)).isFalse();
    }

    @Test
    void testHashCode() {
        LottoNumbers case1 = new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoNumbers case2 = new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoNumbers case3 = new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 1));

        assertThat(case1.hashCode() == case2.hashCode()).isTrue();
        assertThat(case1.hashCode() == case3.hashCode()).isFalse();
    }
}