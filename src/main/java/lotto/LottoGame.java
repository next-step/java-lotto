package lotto;

import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {

    private static final int LOTTO_PRICE = 1000;

    public static void main(String args[]) {

        // 가격 입력
        InputView.printLottoInput();
        var priceInput = InputView.intInput();

        Lottos lottos = new Lottos(priceInput);
        lottos.shuffleLottos(new LottoBalls());

        // 로또 출력
        ResultView.printLottosCount(lottos.getLottoList().size());
        ResultView.printLottos(lottos);

        // 당첨 로또 입력
        InputView.printLottoWinningNumberInput();
        var winningNumberString = InputView.stringInput();
        var winningNumberList = toNumberList(winningNumberString.split(","));

        // 통계
        LottoStatics lottoStatics = new LottoStatics(priceInput, LOTTO_PRICE);
        lottoStatics.calculateProfitStatistics(winningNumberList, lottos.getLottoList());
        ResultView.printStatics(lottoStatics);

        var ratio = lottoStatics.getProfitRatio(winningNumberList, lottos.getLottoList());
        ResultView.printLottosProfit(ratio);
    }

    public static List<Number> toNumberList(String[] strings) {
        List<Number> list = new ArrayList<>();
        for (String string : strings) {
            list.add(Number.createNumber(string.trim()));
        }
        return list;
    }
}
