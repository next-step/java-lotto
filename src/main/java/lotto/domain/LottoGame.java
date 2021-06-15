package lotto.domain;

import java.util.List;

public class LottoGame {
    LottoList lottoList;

    public int getBuyCount(int buyPrice) {
        return buyPrice / LottoConstants.PRICE;
    }

    public LottoList purchaseLotteries(int buyCount) {
        lottoList = new LottoList(buyCount);
        return lottoList;
    }

    public WinningLottoNumbers getWinningNumbers(String winningNumbers, int bonusNumber) {
        return new WinningLottoNumbers(new Lotto(winningNumbers), bonusNumber);
    }

    public LottoList resolveManualLottoList(List<String> manualLottoList) {
        lottoList.resolveManualLottoList(manualLottoList);
        return lottoList;
    }

    public WinningStatistics getWinning(WinningLottoNumbers winningNumbers) {
        return lottoList.getWinning(winningNumbers);
    }
}
