import lotto.domain.Lottos;
import lotto.domain.Winners;
import lotto.view.BuyLottoView;
import lotto.view.SummaryPrinter;
import lotto.view.WinningNumberView;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        Lottos lottos = BuyLottoView.buyLotto();
        Winners winners = WinningNumberView.getWinner(lottos);

        SummaryPrinter.summary(winners);
    }
}