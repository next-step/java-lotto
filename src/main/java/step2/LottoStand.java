package step2;

import java.util.Scanner;

public class LottoStand {

  public static final int ONE_PRICE = 1000;

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    LottoSalesman lottoSalesman = new LottoSalesman(scanner);

    // 구입금액 입력
    int payment = lottoSalesman.purchaseAmount(ONE_PRICE);

    // 수동 구매할 로또 개수 및 로또번호 입력
    Lottos lottos = buyLottos(lottoSalesman, payment);

    // 당첨번호/보너스번호 입력
    Winning winning = createWinning(lottoSalesman);

    // 당첨결과 출력
    informWinning(payment, winning, lottos);
  }

  private static Lottos buyLottos(LottoSalesman lottoSalesman, int payment) {
    int lottoCount = lottoSalesman.manualLottoCount(ONE_PRICE, payment);

    String[] lottoNumbers = lottoSalesman.inputManualLotto(lottoCount);
    Lottos manualLottos = LottosGenerator.manualLottos(payment, lottoNumbers);
    Lottos autoLottos = LottosGenerator.autoLottos(payment, lottoCount);
    Lottos lottos = Lottos.concat(manualLottos, autoLottos);

    // 구입내역 출력
    lottoSalesman.informPurchase(manualLottos, autoLottos);
    return lottos;
  }

  private static Winning createWinning(LottoSalesman lottoSalesman) {
    String lottoNumber = lottoSalesman.winningNumber();
    int bonusNumber = lottoSalesman.bonusNumber();
    Winning winning = new Winning(lottoNumber, bonusNumber);
    return winning;
  }

  private static void informWinning(int payment, Winning winning, Lottos lottos) {
    LottosAnalysis lottosAnalysis = new LottosAnalysis(winning, lottos);
    LottoStats analyze = lottosAnalysis.analyze();
    LottoDashboard.informWinning(analyze, payment);
  }
}
