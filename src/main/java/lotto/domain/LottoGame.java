package lotto.domain;

import java.util.List;

public class LottoGame {
    LottoList lottoList;
    WinningLottoNumbers winningLottoNumbers;

    public int getBuyCount(int buyPrice) {
        return buyPrice / LottoConstants.PRICE;
    }

    public LottoList getLottoList(int buyCount) {
        lottoList = new LottoList(buyCount);
        return lottoList;
    }

    public WinningLottoNumbers getWinningNumbers(String winningNumbers, int bonusNumber) {
        winningLottoNumbers = new WinningLottoNumbers(new Lotto(winningNumbers), bonusNumber);
        return winningLottoNumbers;
    }

    public LottoList getManualLottoList(List<String> manualLottoList) {
        for (String manualLottoStr : manualLottoList) {
            lottoList.getManualLotto(manualLottoStr);
        }
        return lottoList;
    }

    public WinningStatistics getWinning(WinningLottoNumbers winningNumbers) {
        return lottoList.getWinning(winningNumbers);
    }
}
