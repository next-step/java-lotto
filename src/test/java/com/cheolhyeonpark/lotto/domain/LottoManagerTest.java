package com.cheolhyeonpark.lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class LottoManagerTest {

    @Test
    public void createLottoNumbersList() {

        LottoManager lottoManager = new LottoManager(new LottoInformation(10_000) , new AutoGenerator());

        assertThat(lottoManager.getLottoNumbersList().size()).isEqualTo(10);
    }
}