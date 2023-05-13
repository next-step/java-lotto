package lotto;

import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {

    public static void main(String args[]) {
        InputView.printLottoInput();
        var priceInput = InputView.intInput();
        Lottos lottos = new Lottos(priceInput);

        lottos.makeLottos();
        lottos.shuffleLottos(new LottoBalls());

        ResultView.printLottosCount(lottos);
        ResultView.printLottos(lottos);

        InputView.printLottoWinningNumberInput();
        var winningNumberString = InputView.stringInput();

        ResultView.printStatics(lottos, toNumberList(winningNumberString.split(",")));
        ResultView.printLottosProfit(lottos, toNumberList(winningNumberString.split(",")));
    }

    public static List<Number> toNumberList(String[] strings) {
        List<Number> list = new ArrayList<>();
        for (String string : strings) {
            list.add(Number.createNumber(string.trim()));
        }
        return list;
    }
}
