package com.cheolhyeonpark.lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class LottoManagerTest {

    LottoManager lottoManager = new LottoManager(new LottoNumbersList(), new NumbersGenerator());

    @Test
    public void createLottoNumbersList() {
        LottoNumbersList lottoNumbersList = lottoManager.createLottoNumbers(10_000);
        assertThat(lottoNumbersList.getLottoNumbersList().size()).isEqualTo(10);
    }

    @Test
    public void getGameResult() {
        LottoNumbersList lottoNumbersList = lottoManager.createLottoNumbers(10_000);
        assertThat(lottoManager.getGameResult("1, 2, 3, 4, 5, 6", 7)).isNotNull();
    }
}