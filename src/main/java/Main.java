import lotto.lotto.Lotto;
import lotto.shop.Money;
import lotto.shop.Shop;
import lotto.ui.Command;
import lotto.ui.Result;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Command command = new Command();
        Money money = command.inputMoneyAmount();
        Shop shop = new Shop();
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
