package com.cheolhyeonpark.lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoNumbersListTest {

    @Test
    void size() {
        LottoNumbersList lottoNumbersList = new LottoNumbersList();
        lottoNumbersList.addLottoNumbers(new LottoNumbers());

        int size = lottoNumbersList.size();

        assertThat(size).isEqualTo(1);
    }

    @Test
    void getNumbers() {
        LottoNumbersList lottoNumbersList = new LottoNumbersList();
        LottoNumbers lottoNumbers = new LottoNumbers();
        lottoNumbersList.addLottoNumbers(lottoNumbers);

        LottoNumbers result = lottoNumbersList.getNumbers(0);

        assertThat(result).isNotNull();
        assertThat(result.getNumbers()).isEqualTo(lottoNumbers.getNumbers());
    }
}