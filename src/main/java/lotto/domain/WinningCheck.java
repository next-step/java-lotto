package lotto.domain;

import lotto.exception.PrizeOverFlowIsNegativeException;

import java.util.List;

public class WinningCheck {

    private final Lottos myLottos;
    private final WinningNumber winningNumber;

    public WinningCheck(Lottos lottos, WinningNumber winningNumber) {
        this.myLottos = lottos;
        this.winningNumber = winningNumber;
    }

    public int getWinningPrize() {
        List<Lotto> lottoList = myLottos.getLottos();
        int totalPrize = 0;
        int eachPrize = 0;
        for (Lotto lotto : lottoList) {
            eachPrize = LottoWinningStatus(lotto);
            validOverFlow(eachPrize, totalPrize);
            validtotalPrize(eachPrize, totalPrize);
            totalPrize += eachPrize;
        }
        return totalPrize;
    }

    private void validtotalPrize(int eachPrize, int totalPrize) {
        if (eachPrize + totalPrize > 2_000_000_000) {
            throw new IllegalArgumentException("총 상금 20억을 넘길 순 없음");
        }
    }

    private void validOverFlow(int eachPrize, int totalPrize) {
        if (eachPrize + totalPrize < 0) {
            throw new PrizeOverFlowIsNegativeException();
        }
    }


    private int LottoWinningStatus(Lotto lotto) {
        int count = 0;
        List<LottoNumber> lottoNumbers = lotto.getLotto();
        List<LottoNumber> winningNumbers = winningNumber.getWinningNumber();

        for (int i = 0; i < winningNumbers.size(); i++) {
            count += isNumberMatched(winningNumbers, i, lottoNumbers);
        }

        return Prize.getValueByHit(count);
    }

    private int isNumberMatched(List<LottoNumber> winningNumbers, int i, List<LottoNumber> lottoNumbers) {
        if (winningNumbers.get(i).equals(lottoNumbers.get(i))) {
            return 1;
        }
        return 0;
    }

}
