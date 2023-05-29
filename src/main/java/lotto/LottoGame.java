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
        var autoLottoCount = calculateCount(priceInput, LOTTO_PRICE) - manualLottoCount;

        if(autoLottoCount < 0){
            throw new IllegalArgumentException("수동 갯수는 구입금액을 넘을 수 없습니다.");
        }

        InputView.printLottoManualNumberInput(manualLottoCount);

        Lottos manualLottos = new Lottos(LOTTO_PRICE, createManualLottoByInput(manualLottoCount));
        Lottos autoLottos = new Lottos(autoLottoCount, LOTTO_PRICE, new LottoBallPolicy());

        manualLottos.addLottos(autoLottos);

        // 로또 출력
        ResultView.printLottosCount(autoLottoCount, manualLottoCount);
        ResultView.printLottos(manualLottos);

        // 당첨 로또 입력
        InputView.printLottoWinningNumberInput();
        var winningNumberString = InputView.stringInput();
        var winningNumberList = toNumberList(winningNumberString.split(","));

        // 보너스 로또 번호 입력
        InputView.printLottoWinningBonusNumberInput();
        var bonusNumber = new Number(InputView.intInput());

        // 통계
        LottoStatics lottoStatics = new LottoStatics(WinnigLotto.createLotto(winningNumberList, bonusNumber), manualLottos);
        ResultView.printStatics(lottoStatics);

        var ratio = lottoStatics.getProfitRatio();
        ResultView.printLottosProfit(ratio);
    }

    private static List<Lotto> createManualLottoByInput(int manualLottoCount) {
        List<Lotto> lottos = new ArrayList<>();
        for(int i = 0; i< manualLottoCount; i++){
            lottos.add(Lotto.createLotto(toNumberList(InputView.stringInput().split(",")), LOTTO_PRICE));
        }
        return lottos;
    }

    public static List<Number> toNumberList(String[] strings) {
        List<Number> list = new ArrayList<>();
        for (String string : strings) {
            list.add(Number.createNumber(string.trim()));
        }
        return list;
    }

    public static int calculateCount(int totalPrice, int price){
        return totalPrice / price;
    }
}
