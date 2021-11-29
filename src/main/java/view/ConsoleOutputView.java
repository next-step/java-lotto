package view;

import domain.Lottos;

public class ConsoleOutputView implements OutputView
{
    @Override
    public void showTotalNumberOfLottos(int numberOfLottos) {
        System.out.printf("You purchased %d lottos.\n", numberOfLottos);
    }

    @Override
    public void showRandomGeneratedLottos(Lottos lottos) {
        System.out.println(lottos.lottosAsString());
    }

    @Override
    public void showLottoResult(int matchingNumber, int reward, int count) {
        System.out.printf("%d matched (￦%d) - %d\n", matchingNumber, reward, count);
    }

    @Override
    public void showProfitRate(double profitRate) {
        System.out.printf("Total Profit Rate is %.2f\n", profitRate);
    }
}
