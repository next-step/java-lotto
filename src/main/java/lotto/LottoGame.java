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

        Lottos lottos = new Lottos(calculateLottoSize(priceInput), new LottoBallPolicy(), LOTTO_PRICE);

        // 로또 출력
        ResultView.printLottosCount(lottos.getLottoListSize());
        ResultView.printLottos(lottos);

        // 당첨 로또 입력
        InputView.printLottoWinningNumberInput();
        var winningNumberString = InputView.stringInput();
        var winningNumberList = toNumberList(winningNumberString.split(","));

        // 보너스 로또 번호 입력
        InputView.printLottoWinningBonusNumberInput();
        var bonusNumber = InputView.intInput();
        addBonusNumber(bonusNumber, winningNumberList);

        // 통계
        LottoStatics lottoStatics = new LottoStatics();
        lottoStatics.calculateProfitStatistics(WinnigLotto.createLotto(winningNumberList), lottos);
        ResultView.printStatics(lottoStatics);

        var ratio = lottoStatics.getProfitRatio(WinnigLotto.createLotto(winningNumberList), lottos);
        ResultView.printLottosProfit(ratio);
    }

    public static List<Number> toNumberList(String[] strings) {
        List<Number> list = new ArrayList<>();
        for (String string : strings) {
            list.add(Number.createNumber(string.trim()));
        }
        return list;
    }

    public static void addBonusNumber(int bonusNumber, List<Number> numberList) {
        numberList.add(new Number(bonusNumber));
    }

    public static int calculateLottoSize(int inputPrice) {
        return inputPrice / LOTTO_PRICE;
    }
}
