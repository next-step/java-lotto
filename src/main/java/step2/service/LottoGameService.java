package step2.service;

import step2.domain.LottoWinners;
import step2.domain.Lottos;
import step2.domain.WinLottoNumber;

import java.util.Arrays;
import java.util.stream.Collectors;

public class LottoGameService {
    private WinLottoNumber winLottoNumber;

    public LottoGameService(String lottoNumbers, String bonusBall) {
        pickLottoNumberOfWeek(lottoNumbers);
        addBonusBall(bonusBall);
    }

    private void pickLottoNumberOfWeek(String input) {
        winLottoNumber = new WinLottoNumber(input);
    }

    private void addBonusBall(String bonusBall) {
        winLottoNumber.add(bonusBall);
    }

    public LottoWinners match(Lottos lottos) {
        return lottos.match(winLottoNumber.pickLottoNumberOfWeek());
    }

    public double moneyProfitRate(int investMoney, LottoWinners winners) {
        double rate = winners.totalMoney() / (double) investMoney;

        return Math.floor(rate * 100) / 100.0;
    }

}
