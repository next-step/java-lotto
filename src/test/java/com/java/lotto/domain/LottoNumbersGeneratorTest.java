package com.java.lotto.domain;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumbersGeneratorTest {

    @Test
    public void 무작위로_1과_45사이의_숫자_6개_생성() {
        List<Integer> lottoNumbers = LottoNumbersGenerator.automaticNumbersGenerator();
        assertThat(lottoNumbers.size()).isEqualTo(6);
    }
}
