package step2;

import step2.domain.result.LottoResult;
import step2.generator.LottoGenerator;
import step2.view.InputView;
import step2.view.OutputView;

import java.util.List;

public class LottoMain {

  private static final int LOTTO_PRICE = 1000;

  public static void main(String[] args) {
    // 구매 금액 입력 및 구매 가능한 장수 노출
    int lottoPrice = Integer.parseInt(InputView.getLottoPrice());
    int lottoCount = getLottoCount(lottoPrice);
    List<List<Integer>> userLottoList = LottoGenerator.generateList(lottoCount);
    OutputView.printLottoCount(lottoCount);

    // 구매 금액에 의해 구매된 로또 번호 노출
    OutputView.printLottoList(userLottoList);

    // 당첨 번호 입력
    String winningLotto = InputView.getWinningNumbers();
    String bonusNo = InputView.getBonusNumber();

    // 당첨 통계 노출
    LottoGame game = new LottoGame(lottoPrice, lottoCount, userLottoList, winningLotto, bonusNo);
    LottoResult result = game.start();
    OutputView.printLottoMatchResult(result);
  }

  private static int getLottoCount(int lottoPrice) {
    return lottoPrice / LOTTO_PRICE;
  }

}
