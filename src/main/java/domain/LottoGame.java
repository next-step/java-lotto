package domain;

import view.InputView;
import view.ResultView;

import java.util.Scanner;
import java.util.stream.IntStream;

public class LottoGame {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int total = InputView.purchasingAmount();
        int manual = InputView.ManualLotto();

        Money money = Money.amountOfPurchase(total, manual);
        LottoCreate lottos = LottoCreate.from();

        InputView.typeManualLotto();
        IntStream.range(0, money.turnOfManualLotto()).forEach(i -> lottos.getLottocreate().add(Lotto.fromCommas(sc.nextLine())));
        ResultView.printNumberOfLottos(money.turnOfAutoLotto(), manual);

        ResultView.printLottos(lottos.generate(money));

        Lotto winning = Lotto.fromCommas(InputView.typeLottoNumbers());
        WinningLotto winningLotto = WinningLotto.from(winning, InputView.typeBonusNo());

        LottoResult lottoResult = lottos.match(winningLotto);

        ResultView.printResult(lottoResult);
        ResultView.printProfit(lottoResult, total);
    }
}