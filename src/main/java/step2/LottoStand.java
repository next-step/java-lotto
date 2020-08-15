package step2;

import java.util.List;
import java.util.Scanner;

public class LottoStand {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    // 구입금액 입력
    int payment = LottoSalesman.purchaseAmount(scanner);
    List<Lotto> lottos = LottoGenerator.generate(payment);

    // 구입내역 출력
    LottoSalesman.informPurchase(lottos);

    // 당첨번호/보너스번호 입력
    String numbersAsString = LottoSalesman.winningNumber(scanner);
    int bonusNumber = LottoSalesman.bonusNumber(scanner);
    Winning winning = new Winning(numbersAsString, bonusNumber);

    // 당첨결과 출력 
    LottoAnalysis lottoAnalysis = new LottoAnalysis(winning, lottos);
    LottoStats analyze = lottoAnalysis.analyze();
    LottoSalesman.informWinning(scanner, analyze, payment);
  }
}
