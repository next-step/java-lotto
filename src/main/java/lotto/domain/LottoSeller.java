package lotto.domain;

import lotto.dto.BuyableLottoCount;
import lotto.dto.PaymentMoney;

import static lotto.dto.BuyableLottoCount.calculateBuyableCount;

public class LottoSeller {
    private LottoGameGenerator lottoGameGenerator;

    public LottoSeller(LottoGameGenerator lottoGameGenerator) {
        this.lottoGameGenerator = lottoGameGenerator;
    }

    public LottoGames sell(PaymentMoney paymentMoney) {
        LottoPrice.isEnoughMoney(paymentMoney);
        BuyableLottoCount buyableLottoCount = calculateBuyableCount(paymentMoney);

        return generate(buyableLottoCount);
    }

    private LottoGames generate(BuyableLottoCount buyableLottoCount) {
        LottoGames lottoGames = new LottoGames();

        for(int i = 0; buyableLottoCount.isHigher(i) ; i++) {
            LottoGame lottoGame = lottoGameGenerator.generate();
            lottoGames.add(lottoGame);
        }

        return lottoGames;
    }
}
