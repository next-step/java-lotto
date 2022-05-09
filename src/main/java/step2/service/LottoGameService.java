package step2.service;

import step2.domain.LottoNumber;
import step2.domain.LottoWinners;
import step2.domain.Lottos;
import step2.domain.LottoWinNumber;

public class LottoGameService {
    private final LottoWinNumber winLottoNumber;
    private final LottoNumber bonusBall;

    public LottoGameService(String lottoNumbers, String bonusBall) {
        winLottoNumber = new LottoWinNumber(lottoNumbers);
        this.bonusBall = LottoNumber.create(bonusBall);
    }

    public LottoWinners match(Lottos lottos) {
        return lottos.match(winLottoNumber.pickLottoNumberOfWeek(), bonusBall);
    }

    public double moneyProfitRate(int investMoney, LottoWinners winners) {
        double rate = winners.totalMoney() / (double) investMoney;

        return Math.floor(rate * 100) / 100.0;
    }

}
