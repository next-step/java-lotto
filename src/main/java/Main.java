import domain.lotto.LottoMachine;
import domain.lotto.LottoPieces;
import domain.lotto.Lottos;
import domain.strategy.GenerateLottoNum;
import domain.strategy.GenerateLottoNumRandom;
import java.util.Map;
import view.InputView;
import view.ResultView;

public class Main {

  public static void main(String[] args) {
    int price = InputView.paybill();
    int pieces = new LottoPieces(price).pieces;
    ResultView.printLottoAmount(pieces);

    LottoMachine lottoMachine = new LottoMachine();
    GenerateLottoNum generateLottoNum = new GenerateLottoNumRandom();
    Lottos lottos = lottoMachine.makeLottos(pieces, generateLottoNum);
    ResultView.printMyLotto(lottos);

    Map<Integer, Integer> prizeMap = lottoMachine.checkPrizes(InputView.winningNums(), lottos);
    float revenueRatio = lottoMachine.revenueRatio(pieces,
        lottoMachine.calculateTotalPrize(prizeMap));
    ResultView.showPrizeStatistics(prizeMap, revenueRatio);
  }

}
