package step3;

import step3.domain.*;
import step3.view.InputView;
import step3.view.ResultView;

import java.util.List;

public class LottoApp {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        Customer customer = new Customer();

        LottoInfo lottoInfo = new LottoInfo(inputView.requestInput());
        LottoTicket lottoTicket = new LottoTicket(customer.buyLotto(lottoInfo.getCount()));
        resultView.printNumOfLotto(lottoInfo.getCount());
        resultView.printIssuedLottoList(lottoTicket.getBundle());
        WinningLotto winningLotto = new WinningLotto(inputView.requestWinningLottoNumber());
        BonusBall bonusBall = new BonusBall(inputView.requestBonusBall(), winningLotto.getNumbers());
        customer.compareWinningLottoNumbersAndIssuedLottoList(winningLotto.getNumbers(), lottoTicket.getBundle(), bonusBall.getNumber());

        resultView.printMatchedLottoRecord(customer.getResultRankMap());
        resultView.printResultPrice(customer.getResultPrize(), lottoInfo.getCount());


    }

}
