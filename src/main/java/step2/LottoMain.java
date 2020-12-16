package step2;

import step2.domain.result.LottoResult;
import step2.generator.LottoGenerator;
import step2.view.InputView;
import step2.view.OutputView;

import java.util.List;

public class LottoMain {

  private static final int LOTTO_PRICE = 1000;

  public static void main(String[] args) {
    // 구매 금액, 수동 구매수, 수동 구매 번호 입력
    int lottoPrice = InputView.getLottoPrice();
    int manualCount = InputView.getManualLottoCount();
    List<List<Integer>> userLottoList = InputView.getManualLottoNumber(manualCount);

    // 나머지 자동으로 생성
    int autoCount = getLottoCount(lottoPrice) - manualCount;
    userLottoList.addAll(LottoGenerator.randomGenerateList(autoCount));

    // 구매 금액에 의해 구매된 로또 번호 노출
    OutputView.printLottoList(userLottoList, manualCount, autoCount);

    // 당첨 번호 입력
    String winningLotto = InputView.getWinningNumbers();
    String bonusNo = InputView.getBonusNumber();

    // 당첨 통계 노출
    LottoGame game = new LottoGame(lottoPrice, userLottoList, winningLotto, bonusNo);
    LottoResult result = game.start();
    OutputView.printLottoMatchResult(result);
  }

  private static int getLottoCount(int lottoPrice) {
    return lottoPrice / LOTTO_PRICE;
  }

}
