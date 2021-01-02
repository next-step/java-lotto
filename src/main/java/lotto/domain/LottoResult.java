package lotto.domain;

import java.util.Arrays;
import java.util.List;

public class LottoResult {
    private LottoBucket lottoBucket;
    public LottoResult(LottoBucket lottoBucket){
        this.lottoBucket = lottoBucket;
    }

    public WinningLottos checkWinningNumbers(String lastWinnerNumber, BonusNumber bonusNumber) {
        WinningLottos winningLottos = new WinningLottos();
        List<Lotto> lottos = lottoBucket.getLottos();

        for(int i = 0; i < lottos.size(); i++) {
            Lotto lotto = lottos.get(i);
            int matchNumber = lotto.checkLastWinningNumberSet(lastWinnerNumber);
            boolean existBonusNumber = lotto.checkBonusNumber(bonusNumber);
            WinningLottoType winningLottoType = WinningLottoType.valueOf(matchNumber, existBonusNumber);
            winningLottos.addMatchingNumber(winningLottoType);
        }
        return winningLottos;
    }

}
