package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import domain.type.LottoRankResult;

public class LottoRankAmountTest {
    @DisplayName("LottoRankAmout enum test")
    @Test
    void lottoRankAmountTest() {
        LottoRankResult lottoRankAmount;

        lottoRankAmount = LottoRankResult.FIRST;
        lottoRankAmount.equals(1);
        System.out.println(lottoRankAmount.equals(1));
    }

}
