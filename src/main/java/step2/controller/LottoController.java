package step2.controller;

import step2.*;
import step2.domain.LottoSalesPerson;
import step2.domain.LottoTickets;
import step2.domain.PrizeMoney;
import step2.domain.WinningLottoNumbers;
import step2.view.ResultView;

import java.util.HashMap;
import java.util.Map;

public class LottoController {
    private final TheMethodOfPurchase theMethodOfPurchase;
    private final LottoNumberGenerator lottoNumberGenerator;
    private final LottoNumberGenerator winningNumberGenerator;
    private LottoSalesPerson lottoSalesPerson;
    private LottoTickets lottoTickets;
    private Map<Integer, Integer> result = new HashMap<>();

    public LottoController(TheMethodOfPurchase theMethodOfPurchase,
                           LottoNumberGenerator lottoNumberGenerator,
                           LottoNumberGenerator winningNumberGenerator){
        this.theMethodOfPurchase = theMethodOfPurchase;
        this.lottoNumberGenerator = lottoNumberGenerator;
        this.winningNumberGenerator = winningNumberGenerator;
    }

    public void buyLotto(){
        lottoSalesPerson = new LottoSalesPerson(theMethodOfPurchase, lottoNumberGenerator);
        int theNumberOfLotto = lottoSalesPerson.howManyBuyLotto();
        lottoTickets = lottoSalesPerson.makeLotto(theNumberOfLotto);
        ResultView.showMyLottoNumbers(lottoTickets);
    }

    public void checkWinningNumbers(){
        WinningLottoNumbers winningLottoNumbers = new WinningLottoNumbers(winningNumberGenerator);
        winningLottoNumbers.compareToWinningNumbers(lottoTickets);
        result = winningLottoNumbers.getMatchCountMap();
    }

    public void showResult(){
        PrizeMoney prizeMoney = new PrizeMoney();
        prizeMoney.calculateSumOfPrizeMoney(result);
        double earningRatio = prizeMoney.calculateEarningRatio(lottoSalesPerson.getPurchasingAmount());
        ResultView.showResult(result, prizeMoney);
        ResultView.showEarningRatio(earningRatio);
    }
}
