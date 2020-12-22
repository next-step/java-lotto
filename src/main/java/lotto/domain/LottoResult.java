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
            int matchNumber = lottos.get(i).checkLastWinningNumber(lastWinnerNumber);
            //TODO Check BonusNumber in LottoBuckets
            if(matchNumber == 5) {
                boolean existBonusNumber = lottos.get(i).checkBonusNumber(bonusNumber);
                if(existBonusNumber){
                    winningLottoType = WinningLottoType.MATCH_FIVE_BONUS;
                    winningLottos.addMatchingNumber(winningLottoType);
                }
            }
            if(matchNumber != 5) {
                winningLottoType = resultWinningLottoType(matchNumber);
                winningLottos.addMatchingNumber(winningLottoType);
            }

        }
        return winningLottos;
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
