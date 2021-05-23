package lotto;

import lotto.lotto.Answer;
import lotto.lotto.LottoTicket;
import lotto.lotto.MatchedAnswer;
import lotto.shop.Money;
import lotto.shop.Shop;
import lotto.ui.Command;
import lotto.ui.Result;

public class LottoGame {
    public static void start() {
        Shop shop = new Shop();
        Money money = Command.inputMoneyAmount();
        int lottoCount = shop.buyLotto(money);

        Command.printLottoAmount(lottoCount);
        LottoTicket lottoTicket = shop.selectAuto(lottoCount);
        Command.printLottoBundle(lottoTicket);

        Answer answer = new Answer(Command.inputAnswer());
        MatchedAnswer matchAnswer = shop.matchAnswer(lottoTicket, answer);

        Command.resultMessage();
        Result.resultIncome(matchAnswer, money);
    }
}