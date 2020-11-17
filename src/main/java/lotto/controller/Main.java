package lotto.controller;

import lotto.domain.*;
import lotto.dto.LottosDto;
import lotto.dto.MoneyDto;
import lotto.dto.StatisticsDto;
import lotto.dto.WinningConditionDto;
import lotto.view.InputView;
import lotto.view.ResultView;

public class Main {
    public static void main(String[] args) {

        Money purchaseMoney = MoneyDto.of(
                InputView.askPurchaseMoney()
        ).toEntity();
        int numOfLottos = Lotto.getNumOfLottos(purchaseMoney);
        ResultView.printNumOfLottos(numOfLottos);

        Shuffler shuffler = new Shuffler(LottoNo.MIN, LottoNo.MAX);
        Lottos lottos = new Lottos(numOfLottos, () -> new Lotto(
                shuffler.getIntegers(Lotto.SIZE)
        ));
        ResultView.printLottos(new LottosDto(lottos));

        WinningCondition condition = new WinningConditionDto.Builder()
                .winningLotto(InputView.askWinningLotto())
                .bonus(InputView.askBonusBall())
                .build()
                .toEntity();

        ResultView.printStatistics(
                new StatisticsDto(lottos.getResult(condition),
                        purchaseMoney)
        );
    }
}
