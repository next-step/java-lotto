package com.cheolhyeonpark.lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoNumbersListTest {

    NumbersGenerator numbersGenerator = new NumbersGenerator();

    @Test
    void size() {
        LottoNumbersList lottoNumbersList = new LottoNumbersList();
        lottoNumbersList.addLottoNumbers(numbersGenerator.getAutoLottoNumbers());

        int size = lottoNumbersList.size();

        assertThat(size).isEqualTo(1);
    }

    @Test
    void getNumbers() {
        LottoNumbersList lottoNumbersList = new LottoNumbersList();
        LottoNumbers lottoNumbers = numbersGenerator.getAutoLottoNumbers();
        lottoNumbersList.addLottoNumbers(lottoNumbers);

        LottoNumbers result = lottoNumbersList.getNumbers(0);

        assertThat(result).isNotNull();
        assertThat(result.toString()).isEqualTo(lottoNumbers.toString());
    }
}