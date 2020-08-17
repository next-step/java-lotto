package step2;

import java.util.Scanner;

public class LottoStand {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    // 구입금액 입력
    int payment = LottoSalesman.purchaseAmount(scanner);

    // 수동 구매할 로또 개수
    int lottoCount = LottoSalesman.manualLottoCount(scanner);

    // 수동 로또번호 입력
    String[] lottoNumbers = LottoSalesman.inputManualLotto(scanner, lottoCount);
    Lottos manualLottos = LottosGenerator.valueOf(payment, lottoNumbers);
    Lottos autoLottos = LottosGenerator.generate(payment, lottoCount);

   // 구입내역 출력
    LottoSalesman.informPurchase(manualLottos, autoLottos);

    // 당첨번호/보너스번호 입력
    String numbersAsString = LottoSalesman.winningNumber(scanner);
    int bonusNumber = LottoSalesman.bonusNumber(scanner);
    Winning winning = new Winning(numbersAsString, bonusNumber);

    // 당첨결과 출력
    Lottos lottos = Lottos.concat(manualLottos, autoLottos);
    LottoAnalysis lottoAnalysis = new LottoAnalysis(winning, lottos);
    LottoStats analyze = lottoAnalysis.analyze();
    LottoSalesman.informWinning(scanner, analyze, payment);
  }
}
