package com.cheolhyeonpark.lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class LottoResultTest {

    @Test
    void getYields() {
        LottoResult lottoResult = new LottoResult();
        lottoResult.count(Rank.FIFTH);

        double result = lottoResult.getYields(new Amount(Amount.GAME_PRICE));

        assertThat(result).isEqualTo((double) Rank.FIFTH.getPrice() / Amount.GAME_PRICE);
    }
}