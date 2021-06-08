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

    public WinningStatistics getWinning() {
        List<Rank> list = new ArrayList<>();
        for (Lotto lotto : lottoList.getLottoList()) {
            int numberOfWinnings = 0;
            numberOfWinnings = getNumberOfWinnings(lotto, numberOfWinnings);
            boolean bonus = false;
            bonus = isBonus(lotto, bonus);
            Rank rank = Rank.getRank(numberOfWinnings, bonus);
            list.add(rank);
        }

        return new WinningStatistics(list.stream().collect(Collectors.groupingBy(x -> x, Collectors.counting())));
    }

    private boolean isBonus(Lotto lotto, boolean bonus) {
        if (lotto.getLottoNumbers().contains(winningLottoNumbers.getBonusNumber())) {
            bonus = true;
        }
        return bonus;
    }

    private int getNumberOfWinnings(Lotto lotto, int numberOfWinnings) {
        for (int lottoNumber : lotto.getLottoNumbers()) {
            if (winningLottoNumbers.getWinningLottoNumbers().getLottoNumbers().contains(lottoNumber)) {
                numberOfWinnings++;
            }
        }
        return numberOfWinnings;
    }

    public void getManualLottoList(List<String> manualLottoList) {
        for (String manualLottoStr : manualLottoList) {
            lottoList.getManualLotto(manualLottoStr);
        }
    }
}
