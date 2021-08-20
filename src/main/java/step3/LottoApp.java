package step3;

import step3.domain.*;
import step3.view.InputView;
import step3.view.ResultView;

public class LottoApp {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        Customer customer = new Customer();

        LottoInfo lottoInfo = new LottoInfo(inputView.requestCharge());
        ManualLottoCount manualLottoCount = new ManualLottoCount(inputView.requestManualPurchase(), lottoInfo.getCount());

        LottoTicket lottoTicket = new LottoTicket();
        for (int i = 0; i < manualLottoCount.getNumOfManualPurchaseLotto(); i++) {
            LottoNumbers manualLottoNumber = new LottoNumbers(inputView.requestManualLottoNumber());
            lottoTicket.addLotto(manualLottoNumber.getList());
        }
        lottoTicket.addBundle(customer.buyLotto(lottoInfo.getCount()- manualLottoCount.getNumOfManualPurchaseLotto()));

        resultView.printNumOfLotto(lottoInfo.getCount(), manualLottoCount.getNumOfManualPurchaseLotto());
        resultView.printIssuedLottoList(lottoTicket.getBundle());
        LottoNumbers lottoNumbers = new LottoNumbers(inputView.requestWinningLottoNumber());
        BonusBall bonusBall = new BonusBall(inputView.requestBonusBall(), lottoNumbers.getList());
        customer.compareWinningLottoNumbersAndIssuedLottoList(lottoNumbers.getList(), lottoTicket.getBundle(), bonusBall.getNumber());

        resultView.printMatchedLottoRecord(customer.getResultRankMap());
        resultView.printResultPrice(customer.getResultPrize(), lottoInfo.getCount());
    }
}
