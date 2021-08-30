package com.techmoa.lotto;

import com.techmoa.lotto.model.LottoWinScope;
import com.techmoa.lotto.service.LottoAnswer;
import com.techmoa.lotto.service.LottoService;
import com.techmoa.lotto.service.LottoTickets;
import com.techmoa.lotto.model.LottoWinResult;
import com.techmoa.lotto.view.InputView;
import com.techmoa.lotto.view.OutputView;

public class LottoStarter {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        LottoService lottoService = new LottoService();

        // 구입금액 입력 받기
        InputView.enterPurchaseAmount();
        int purchaseAmount = inputView.getPurchaseAmount();

        // 로또 번호 생성
        lottoService.startLotto(purchaseAmount);
        LottoTickets lottoTickets = lottoService.getLottoTickets();

        // 로또 번호 출력
        outputView.printOwnLotto(lottoTickets);

        // 지난 로또 입력 받기
        InputView.enterLastWinnerNumber();
        LottoAnswer lottoAnswer = LottoAnswer.of(InputView.getWinEnterString(),purchaseAmount );

        // 로또 통계 출력
        LottoWinResult lottoWinResult = LottoWinScope.checkWinnings(lottoAnswer, lottoTickets);
        //LottoWinResult lottoWinResult = lottoService.checkWinnings(lottoAnswer , lottoTickets);
        outputView.printAnswerResult(lottoWinResult);
    }
}
