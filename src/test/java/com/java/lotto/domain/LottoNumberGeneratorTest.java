package com.java.lotto.domain;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumberGeneratorTest {

    @Test
    public void 무작위_번호_하나_생성_1과_45사이() {
        List<Integer> lottoNumbers = LottoNumberGenerator.generator();
        assertThat(lottoNumbers.size()).isEqualTo(6);
    }
}
