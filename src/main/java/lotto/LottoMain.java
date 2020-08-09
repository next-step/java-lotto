package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoGame;
import lotto.domain.LottoResult;
import lotto.domain.LottoShop;
import lotto.view.LottoInputView;
import lotto.view.LottoResultView;

import java.util.List;

public class LottoMain {
    public static void main(String[] args) {
        // 입력 시작
        int price = LottoInputView.purchasePrice();
        List<Lotto> lottos = LottoShop.buyAuto(price);
        LottoResultView.printPurchasedLottoNumbers(lottos);

        String winningNumbers = LottoInputView.lastWeekWinningNumber();
        // 입력 종료

        LottoGame lottoGame = new LottoGame();
        lottoGame.setWinningLotto(Lotto.fromString(winningNumbers));

        LottoResult lottoResult = lottoGame.match(lottos);

        // 결과 출력 시작
        LottoResultView.printWinningResult(lottoResult.getRankingMap());
        LottoResultView.printSaveOfReturn(lottoResult.getTotalPrize() * 1.0 / price);
        // 결과 출력 종료
    }
}
