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
        lottoNumbersList.addLottoNumbers(new LottoNumbers());

        LottoNumbers lottoNumbers = lottoNumbersList.getNumbers(0);

        assertThat(lottoNumbers).isNotNull();
    }
}