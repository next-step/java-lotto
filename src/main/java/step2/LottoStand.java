package step2;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoStand {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    // 구입금액 입력
    int payment = LottoSalesman.purchaseAmount(scanner);

    // 수동 구매할 로또 개수
    int lottoCount = LottoSalesman.manualLottoCount(scanner);

    // 수동 로또번호 입력
    String[] lottoNumbers = LottoSalesman.inputManualLotto(scanner, lottoCount);
    List<Lotto> manualLottos = LottoGenerator.asLottos(payment, lottoNumbers);
    List<Lotto> autoLottos = LottoGenerator.generate(payment, lottoCount);

   // 구입내역 출력
    LottoSalesman.informPurchase(manualLottos, autoLottos);

    // 당첨번호/보너스번호 입력
    String numbersAsString = LottoSalesman.winningNumber(scanner);
    int bonusNumber = LottoSalesman.bonusNumber(scanner);
    Winning winning = new Winning(numbersAsString, bonusNumber);

    // 당첨결과 출력
    List<Lotto> lottos = Stream.concat(manualLottos.stream(), autoLottos.stream()).collect(Collectors.toList());
    LottoAnalysis lottoAnalysis = new LottoAnalysis(winning, lottos);
    LottoStats analyze = lottoAnalysis.analyze();
    LottoSalesman.informWinning(scanner, analyze, payment);
  }
}
