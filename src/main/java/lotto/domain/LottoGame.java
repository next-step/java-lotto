package lotto.domain;

import java.util.List;

public class LottoGame {
    LottoList lottoList = new LottoList();

    public int getBuyCount(int buyPrice) {
        return buyPrice / LottoConstants.PRICE;
    }

    public LottoList purchaseAutoLottoList(int buyCount) {
        lottoList.purchaseAutoLottoList(buyCount);
        return lottoList;
    }

    public WinningLottoNumbers getWinningNumbers(String winningNumbers, int bonusNumber) {
        return new WinningLottoNumbers(new Lotto(winningNumbers), new LottoNumber(bonusNumber));
    }

    public LottoList purchaseManualLottoList(List<String> manualLottoList) {
        lottoList.purchaseManualLottoList(manualLottoList);
        return lottoList;
    }

    public WinningStatistics getWinning(WinningLottoNumbers winningNumbers) {
        return lottoList.getWinning(winningNumbers);
    }
}
