package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import domain.type.LottoRankAmount;

public class LottoRankAmountTest {
    @DisplayName("LottoRankAmout enum test")
    @Test
    void lottoRankAmountTest() {
        LottoRankAmount lottoRankAmount;

        lottoRankAmount = LottoRankAmount.FIRST;
        lottoRankAmount.equals(1);
        System.out.println(lottoRankAmount.equals(1));
    }

}
