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
        Command command = new Command();

        Shop shop = new Shop();
        Money money = command.inputMoneyAmount();
        int lottoCount = shop.buyLotto(money);

        command.printLottoAmount(lottoCount);
        LottoTicket lottoTicket = shop.selectAuto(lottoCount);
        command.printLottoBundle(lottoTicket);

        Answer answer = new Answer(command.inputAnswer());
        MatchedAnswer matchAnswer = shop.matchAnswer(lottoTicket, answer);

        command.resultMessage();
        Result.resultIncome(matchAnswer, money);
    }
}