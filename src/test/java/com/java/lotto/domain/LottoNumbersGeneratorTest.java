package com.java.lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumbersGeneratorTest {

    @Test
    @DisplayName("1과 45 사이의 숫자를 무작위로 생성")
    public void automaticNumbersGenerator() {
        List<Integer> lottoNumbers = LottoNumbersGenerator.automaticNumbersGenerator();
        assertThat(lottoNumbers.size()).isEqualTo(6);
    }
}
