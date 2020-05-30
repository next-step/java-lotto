package com.cheolhyeonpark.lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class LottoManagerTest {

    LottoManager lottoManager = new LottoManager(new LottoNumbersList() , new AutoGenerator());

    @Test
    public void createLottoNumbersList() {
        LottoNumbersList lottoNumbersList = lottoManager.createLottoNumbers(10_000);
        assertThat(lottoNumbersList.getLottoNumbersList().size()).isEqualTo(10);
    }

    @Test
    public void getGameResult() {
        LottoNumbersList lottoNumbersList = lottoManager.createLottoNumbers(10_000);
        assertThat(lottoManager.getGameResult(Arrays.asList(1, 2, 3, 4, 5, 6))).isNotNull();
    }
}