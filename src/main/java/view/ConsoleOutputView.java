package view;

import domain.LottoResult;
import domain.Lottos;

public class ConsoleOutputView implements OutputView
{
    @Override
    public void showTotalNumberOfLottos(int numberOfLottos) {
        System.out.printf("You purchased %d lottos.\n", numberOfLottos);
    }

    @Override
    public void showRandomGeneratedLottos(Lottos lottos) {

    }

    @Override
    public void showLottoResult(LottoResult lottoResult) {

    }

    @Override
    public void showProfitRate(double profitRate) {
        System.out.printf("Total Profit Rate is %.2f\n", profitRate);
    }
}
