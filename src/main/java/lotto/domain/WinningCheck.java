package lotto.domain;

import java.util.List;

public class WinningCheck {
    Lottos myLottos;
    WinningNumber winningNumber;

    public WinningCheck(Lottos lottos, WinningNumber winningNumber) {
        this.myLottos = lottos;
        this.winningNumber = winningNumber;
    }
git add
    public int getWinningPrize() {
        int loop = myLottos.getNumberOfLotto();
        int prize=0;
        for(int i = 0; i < loop; i++) {
            prize+=LottoWinningStatus(myLottos.getLotto(i));
        }
        return prize;
    }

    private int LottoWinningStatus(Lotto lotto) {
        int count = 0;
        List<Integer> lottoNumbers = lotto.getLotto();
        List<Integer> winningNumbers = winningNumber.getWinningNumber();

        for(int i = 0; i < winningNumbers.size(); i++) {
            count += checkThisNumberIsHit(winningNumbers, i, lottoNumbers);
        }
        return PRIZE.getValueByHit(count);
    }

    private static int checkThisNumberIsHit(List<Integer> winningNumbers, int i, List<Integer> lottoNumbers) {
        if(winningNumbers.get(i).equals(lottoNumbers.get(i))) {
            return 1;
        }
        return 0;
    }

}
