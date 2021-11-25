package lotto;

import lotto.service.LottoGameService;

public class LottoMain {
    public static void main(String[] args)  {
        LottoGameService lottoGameService = new LottoGameService();
        lottoGameService.buyLotto();
        lottoGameService.getLastWeekWinningNumbers();
        lottoGameService.matchLottoNumbers();
        lottoGameService.resultWinLotto();
        lottoGameService.resultTotalReward();
    }
}
