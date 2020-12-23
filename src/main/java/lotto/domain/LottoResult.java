package lotto.domain;

import java.util.Arrays;
import java.util.List;

public class LottoResult {
    private LottoBucket lottoBucket;
    public LottoResult(LottoBucket lottoBucket){
        this.lottoBucket = lottoBucket;
    }
    public LottoResult(LottoBucket lottoBucket, BonusNumber bonusNumber){
        this.lottoBucket = lottoBucket;
    }

    public WinningLottos checkWinningNumbers(String lastWinnerNumber, BonusNumber bonusNumber) {
        WinningLottos winningLottos = new WinningLottos();
        List<Lotto> lottos = lottoBucket.getLottos();

        for(int i = 0; i < lottos.size(); i++) {
            WinningLottoType winningLottoType;
            Lotto lotto = lottos.get(i);
            int matchNumber = lotto.checkLastWinningNumber(lastWinnerNumber);

            winningLottoType = matchingWinningLottoType(bonusNumber, lotto, matchNumber);
            winningLottos.addMatchingNumber(winningLottoType);
        }
        return winningLottos;
    }

    private WinningLottoType matchingWinningLottoType(BonusNumber bonusNumber, Lotto lotto, int matchNumber) {
        if(matchNumber == 5) {
            boolean existBonusNumber = lotto.checkBonusNumber(bonusNumber);
            if(existBonusNumber){
                return WinningLottoType.MATCH_FIVE_BONUS;
            }
        }
        return resultWinningLottoType(matchNumber);
    }

    protected WinningLottoType resultWinningLottoType(int matchCount) {
        if( matchCount < 3){
            return WinningLottoType.MATCH_ZERO;
        }
        WinningLottoType winningLottoType = Arrays.stream(WinningLottoType.values())
                                                .filter( (winningType) -> winningType.matchCount == matchCount).findFirst().get();
        return winningLottoType;
    }

}
