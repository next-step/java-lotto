package step2;

import java.util.Scanner;

public class LottoStand {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    LottoSalesman lottoSalesman = new LottoSalesman(scanner);

    // 구입금액 입력
    int payment = lottoSalesman.purchaseAmount();

    // 수동 구매할 로또 개수
    int lottoCount = lottoSalesman.manualLottoCount();

    // 수동 로또번호 입력
    String[] lottoNumbers = lottoSalesman.inputManualLotto(lottoCount);
    Lottos manualLottos = LottosGenerator.manualLottos(payment, lottoNumbers);
    Lottos autoLottos = LottosGenerator.autoLottos(payment, lottoCount);

    // 구입내역 출력
    lottoSalesman.informPurchase(manualLottos, autoLottos);

    // 당첨번호/보너스번호 입력
    String lottoNumber = lottoSalesman.winningNumber();
    int bonusNumber = lottoSalesman.bonusNumber();
    Winning winning = new Winning(lottoNumber, bonusNumber);

    // 당첨결과 출력
    Lottos lottos = Lottos.concat(manualLottos, autoLottos);
    LottosAnalysis lottosAnalysis = new LottosAnalysis(winning, lottos);
    LottoStats analyze = lottosAnalysis.analyze();
    lottoSalesman.informWinning(analyze, payment);
  }
}
