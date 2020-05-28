package com.cheolhyeonpark.lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class LottoManagerTest {

    private final LottoManager lottoManager = new LottoManager(new AutoGenerator());

    @Test
    public void createLottoNumbersList() {
        int amount = 10_000;

        lottoManager.createLottoNumbers(amount);

        assertThat(lottoManager.getLottoNumbersList().size()).isEqualTo(10);
    }
}