package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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



    public void getManualLottoList(List<String> manualLottoList) {
        for (String manualLottoStr : manualLottoList) {
            lottoList.getManualLotto(manualLottoStr);
        }
    }

    public WinningStatistics getWinning(WinningLottoNumbers winningNumbers) {
        return lottoList.getWinning(winningNumbers);
    }
}
