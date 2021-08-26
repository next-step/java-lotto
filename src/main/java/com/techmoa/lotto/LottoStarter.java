package com.techmoa.lotto;

import com.techmoa.lotto.service.LottoService;
import com.techmoa.lotto.service.LottoTickets;
import com.techmoa.lotto.service.LottoWinResult;
import com.techmoa.lotto.view.InputView;
import com.techmoa.lotto.view.OutputView;

public class LottoStarter {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        LottoService lottoService = new LottoService();

        // 구입금액 입력 받기
        inputView.enterPurchaseAmount();
        int purchaseAmount = inputView.getPurchaseAmount();

        // 로또 번호 생성
        lottoService.createLotto(purchaseAmount);
        LottoTickets lottoTickets = lottoService.getLottoTickets();

        // 로또 번호 출력
        outputView.printOwnLotto(lottoTickets);

        // 지난 로또 입력 받기
        inputView.enterLastWinnerNumber();

        // 로또 통계 출력
        LottoWinResult lottoWinResult = lottoService.checkWinnings(inputView.getLottoAnswer() , lottoTickets);
        outputView.printAnswerResult(lottoWinResult);
    }
}
