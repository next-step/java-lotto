package lotto.domain;

import java.util.Arrays;
import java.util.List;

public class LottoResult {
    private LottoBucket lottoBucket;
    public LottoResult(LottoBucket lottoBucket){
        this.lottoBucket = lottoBucket;
    }

    public WinningLottos checkWinningNumbers(String lastWinnerNumber) {
        WinningLottos winningLottos = new WinningLottos();
        List<Lotto> lottos = lottoBucket.getLottos();
        for(int i = 0; i < lottos.size(); i++) {
            int matchNumber = lottos.get(i).checkLastWinningNumber(lastWinnerNumber);
            WinningLottoType winningLottoType = resultWinningLottoType(matchNumber);
            winningLottos.addMatchingNumber(winningLottoType);
        }
        return winningLottos;
    }

    protected WinningLottoType resultWinningLottoType(int matchCount){
        if( matchCount < 3){
            return WinningLottoType.MATCH_ZERO;
        }
        WinningLottoType winningLottoType = Arrays.stream(WinningLottoType.values()).filter( (winningType) -> winningType.matchCount == matchCount).findFirst().get();
        return winningLottoType;
    }

}
