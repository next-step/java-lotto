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

        // 수동 로또 수
        InputView.printLottoManualCountInput();
        var manualLottoCount = InputView.intInput();

        InputView.printLottoManualNumberInput(manualLottoCount);

        Lottos manualLottos = new Lottos(priceInput, LOTTO_PRICE, createNumbersListByInput(manualLottoCount));
        Lottos autoLottos = new Lottos(priceInput - manualLottos.getLottoAllPrice(), LOTTO_PRICE, new LottoBallPolicy());

        manualLottos.addLottos(autoLottos);

        // 로또 출력
        ResultView.printLottosCount(autoLottos, manualLottos);
        ResultView.printLottos(manualLottos);

        // 당첨 로또 입력
        InputView.printLottoWinningNumberInput();
        var winningNumberList = new Numbers(InputView.stringInput().split(","));

        // 보너스 로또 번호 입력
        InputView.printLottoWinningBonusNumberInput();
        var bonusNumber = new Number(InputView.intInput());

        // 통계
        LottoStatics lottoStatics = new LottoStatics(WinnigLotto.createLotto(winningNumberList.getNumbers(), bonusNumber), manualLottos);
        ResultView.printStatics(lottoStatics);

        var ratio = lottoStatics.getProfitRatio();
        ResultView.printLottosProfit(ratio);
    }

    private static List<Numbers> createNumbersListByInput(int manualLottoCount) {
        List<Numbers> numbersList = new ArrayList<>();
        for(int i = 0; i< manualLottoCount; i++){
            Numbers numbers = new Numbers(InputView.stringInput().split(","));
            numbersList.add(numbers);
        }
        return numbersList;
    }
}
