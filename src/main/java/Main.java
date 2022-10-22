import domain.LottoMachine;
import view.InputView;
import view.ResultView;

public class Main {

  public static void main(String[] args) {
    int amount = InputView.paybill();
    LottoMachine lottoMachine = new LottoMachine();

    float totalPrize = lottoMachine.calculateTotalPrize(InputView.winningNums(),amount);
    float revenueRatio =lottoMachine.revenueRatio(amount,totalPrize);
    ResultView.showPrizeStatistics(lottoMachine.getPrizeMap(),revenueRatio);
  }

}
