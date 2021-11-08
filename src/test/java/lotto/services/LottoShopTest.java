package lotto.services;

import lotto.domains.LottoResult;
import lotto.domains.LottoResults;
import lotto.domains.Lottos;
import org.junit.jupiter.api.Test;

class LottoShopTest {

    @Test
    void winner_찾기() {
        LottoShop lottoShop = new LottoShop("1, 2, 3, 4, 5, 6");
        LottoResults lottoResults = lottoShop.winner(new Lottos("14000"));

        for (LottoResult lottoResult : lottoResults.getLottoResults()) {
            System.out.println(lottoResult.detailedInfo());
        }
    }

}