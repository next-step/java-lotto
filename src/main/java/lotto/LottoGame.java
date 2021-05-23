package lotto.game;

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
        LottoTicket lottoBundle = shop.selectAuto(lottoCount);
        command.printLottoBundle(lottoBundle);

        Answer answer = new Answer(command.inputAnswer());
        MatchedAnswer matchAnswer = shop.matchAnswer(lottoBundle, answer);

        command.resultMessage();
        Result.resultIncome(matchAnswer, money);
    }
}