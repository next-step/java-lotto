package lotto.game;

import java.util.List;
import java.util.Map;
import java.util.Set;

import lotto.lotto.Lotto;
import lotto.shop.Money;
import lotto.shop.Shop;
import lotto.ui.Command;
import lotto.ui.Result;

public class LottoGame {
    public static void start() {
        Command command = new Command();

        Shop shop = new Shop();
        Money money = command.inputMoneyAmount();
        int amount = shop.buyLotto(money);

        command.printLottoAmount(amount);
        List<Lotto> lottoBundle = shop.selectAuto(amount);
        command.printLottoBundle(lottoBundle);

        Set<Integer> answer = command.inputAnswer();
        Map<Integer, Integer> matchAnswer = shop.matchAnswer(lottoBundle, answer);

        command.resultMessage();
        Result.resultIncome(matchAnswer, money);
    }
}
