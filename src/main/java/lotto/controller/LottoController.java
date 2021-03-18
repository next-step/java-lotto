package lotto.controller;

import lotto.domain.LottoMachine;
import lotto.domain.LottoRank;
import lotto.domain.LottoYield;
import lotto.domain.SbsHappyDreamLottoLive;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoController {
    public void run() {
        // 구매 금액 입력
        InputView inputView = new InputView();
        int buyAmount = inputView.inputBuyAmount();

        // 로또 발급
        LottoMachine lottoMachine = new LottoMachine(buyAmount);

        // 로또 번호 확인
        ResultView resultView = new ResultView();
        resultView.printLottoTicketInfos(lottoMachine);

        // 당첨 결과 확인
        String winnerNumbers = inputView.inputWinnerNumber();
        SbsHappyDreamLottoLive sbsHappyDreamLottoLive = new SbsHappyDreamLottoLive(winnerNumbers, lottoMachine);

        List<LottoRank> lottoRanks = sbsHappyDreamLottoLive.readOnlyLottoRanks();

        LottoYield lottoYield = new LottoYield(lottoRanks, buyAmount);

        // 당첨 내역 출력
        resultView.printLottoRanksInfos(lottoRanks, lottoYield);
    }
}
