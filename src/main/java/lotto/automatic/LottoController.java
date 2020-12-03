package lotto.automatic;

import lotto.automatic.domain.Lotto;
import lotto.automatic.domain.LottoRank;
import lotto.automatic.domain.LottoResult;
import lotto.automatic.domain.WinningLotto;
import lotto.automatic.dto.LottoBuyingMoneyAndAmount;
import lotto.automatic.view.InputView;
import lotto.automatic.view.OutputView;

import java.util.List;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;
    private final LottoGame lottoGame;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoGame = new LottoGame();
    }

    public void request(){

        LottoBuyingMoneyAndAmount lottoBuyingMoneyAndAmount = getLottoMoney();
        List<Lotto> lottoList = getLottoList(lottoBuyingMoneyAndAmount);

        outputView.printLottoList(lottoList);

        WinningLotto winningLotto = getWinningLotto();
        List<LottoRank> lottoRankList = winningLotto.getRankList(lottoList);
        LottoResult result = getResult(lottoBuyingMoneyAndAmount, lottoRankList);

        outputView.printLottoResult(result);

    }

    private LottoResult getResult(LottoBuyingMoneyAndAmount lottoBuyingMoneyAndAmount, List<LottoRank> lottoRankList) {
        return lottoGame.getLottoResult(lottoBuyingMoneyAndAmount.getInvestMoney(), lottoRankList);
    }

    private WinningLotto getWinningLotto() {
        return inputView.getWinningLottoNums();
    }

    private List<Lotto> getLottoList(LottoBuyingMoneyAndAmount lottoBuyingMoneyAndAmount) {
        return lottoGame.generateLotto(lottoBuyingMoneyAndAmount.getCountOfLotto());
    }

    private LottoBuyingMoneyAndAmount getLottoMoney() {
        return inputView.getLottoMoneyAndAmount();
    }

}
