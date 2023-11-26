import lotto.LottoResult;
import lotto.LottoStore;
import lotto.Lottos;
import view.InPutView;
import view.OutPutView;

public class Core {

  public static void main(String[] args) {

    int amount = InPutView.getAmount();

    LottoStore lottoStore = new LottoStore();
    Lottos lottos = lottoStore.sell(amount);

    OutPutView.printLotto(lottos);

    String resultLottoNumbers = InPutView.getResultLottoNumbers();

    LottoResult result = lottoStore.result(lottos, resultLottoNumbers);
    double profitRate = result.calculateProfitRate(amount);

    // 결과 프린트
    OutPutView.printResult(result);
    OutPutView.printProfitRate(profitRate);
  }

}
