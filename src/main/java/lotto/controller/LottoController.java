package lotto.controller;

import lotto.domain.Prize;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.generate.LottoGenerate;
import lotto.domain.lotto.ticket.LottoNumber;
import lotto.domain.lotto.ticket.LottoTicket;
import lotto.domain.lotto.ticket.LottoTickets;
import lotto.domain.purchase.Purchase;
import java.util.Map;
import static lotto.domain.statistics.Statistics.*;
import static lotto.view.InputView.*;
import static lotto.view.ResultView.*;

public class LottoController {

    public static void main(String[] args) {
        Purchase purchase = new Purchase(questionInputMoney(), new LottoGenerate(), new LottoTickets());
        Lotto lotto = new Lotto(purchase.purchaseLotto(), new LottoGenerate());

        purchaseResultView(purchase.purchaseLottoCount());
        getLottoNumbersSentence(lotto);

        String winnerLottoNumber = questionWinnerNumber();
        LottoTicket lastWeekWinningNumbers = new LottoTicket(winnerLottoNumber);
        LottoNumber bonusLottoNumber = new LottoNumber(questionBonusLottoNumber());
        Map<Prize, Integer> hitLottoNumbers = lotto.getHitLottoNumbers(lastWeekWinningNumbers, bonusLottoNumber);

        prizeResultView(hitLottoNumbers);
        statisticsResultView(calculateReturnRatio(purchase.purchaseLottoCount(), hitLottoNumbers));
    }

}
