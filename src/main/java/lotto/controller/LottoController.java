package lotto.controller;

import lotto.domain.Prize;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.generate.LottoGenerate;
import lotto.domain.lotto.ticket.LottoNumber;
import lotto.domain.lotto.ticket.LottoTicket;
import lotto.domain.lotto.ticket.LottoTickets;
import lotto.domain.purchase.Money;
import lotto.domain.purchase.Purchase;

import java.util.List;
import java.util.Map;

import static lotto.domain.purchase.PassivityLottoCount.isValidate;
import static lotto.domain.statistics.Statistics.*;
import static lotto.view.InputView.*;
import static lotto.view.ResultView.*;

public class LottoController {

    public static void main(String[] args) {
        int money = questionInputMoney();
        int passivityLottoCount = isValidate(new Money(money), questionPassivityInput());

        List<String> fromStringList = questionInputPassivityLotto(passivityLottoCount);
        LottoTickets lottoTickets = LottoTickets.fromStringList(fromStringList);

        Purchase purchase = new Purchase(money, passivityLottoCount, new LottoGenerate(), lottoTickets);
        Lotto lotto = new Lotto(purchase.purchaseAutoLotto(), new LottoGenerate());

        purchaseResultView(purchase.purchasePassivityLottoCount(),purchase.purchaseAutoLottoCount());
        getLottoNumbersSentence(lotto);

        String winnerLottoNumber = questionWinnerNumber();
        LottoTicket lastWeekWinningNumbers = new LottoTicket(winnerLottoNumber);
        LottoNumber bonusLottoNumber = new LottoNumber(questionBonusLottoNumber());

        Map<Prize, Integer> hitLottoNumbers = lotto.getHitLottoNumbers(lastWeekWinningNumbers, bonusLottoNumber);
        prizeResultView(hitLottoNumbers);
        statisticsResultView(calculateReturnRatio(purchase.purchaseAllLottoCount(), hitLottoNumbers));
    }

}
