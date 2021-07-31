package lottos;


import lottos.controller.ConsoleInputView;
import lottos.controller.ConsoleOutputView;
import lottos.domain.Lotto;
import lottos.domain.Lottos;
import lottos.domain.Shop;

import java.util.List;

public class ApplicationRunner {

    public static void main(String[] args) {

        ConsoleInputView consoleInputView = new ConsoleInputView();
        int price = consoleInputView.buy();

        Shop shop = new Shop();
        Lottos lottos = shop.issue(price);

        ConsoleOutputView consoleOutputView = new ConsoleOutputView();
        consoleOutputView.print(lottos);

        List<Integer> lastWeekWinningNumbers = consoleInputView.lastWeeksWinningNumbers();
        Lotto lastWeekWiningLotto = new Lotto(lastWeekWinningNumbers);
    }
}
