package lotto.service;

import lotto.entity.Lotto;
import lotto.entity.WinningLotto;
import lotto.view.LottoViewer;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RottoRunner {
    private final Scanner scan = new Scanner(System.in);

    private final LottoSeller seller = new LottoSeller();
    private final LottoResultChecker resultChecker = new LottoResultChecker();
    private final LottoViewer viewer = new LottoViewer();

    public void run() {
        viewer.printInputMoney();
        var money = Integer.parseInt(scan.nextLine());

        var lottos = seller.buyLotto(money);
        viewer.printLottos(lottos);

        viewer.inputWinningNumber();
        var winningNumbers = Arrays.stream(scan.nextLine().split(","))
                .map(s -> {
                    var result = s.trim();
                    return Integer.parseInt(result);
                })
                .collect(Collectors.toSet());
        viewer.inputBonusNumber();
        var bonusNumber = Integer.parseInt(scan.nextLine());

        var result = resultChecker.checkResult(lottos, new WinningLotto(new Lotto(winningNumbers), bonusNumber));
        var rateOfReturn = (double) result.getAllReward() / money;
        viewer.printResult(result, rateOfReturn);
    }
}
