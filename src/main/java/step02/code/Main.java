package step02.code;

import java.util.Map;

import step02.code.common.InputView;
import step02.code.common.ResultView;
import step02.code.domain.GradeEnum;
import step02.code.domain.Lotto;
import step02.code.domain.Lottos;
import step02.code.domain.Number;
import step02.code.domain.Outcome;

public class Main {
  public static void main(String[] args) {
    int money = InputView.buy();

    Lottos lottos = Lottos.buy(money);
    ResultView.myLotto(lottos.lottos());

    Lotto winningNumber = Lotto.makeLottoByString(InputView.winningNumber());

    Number bonus = Number.numberByString(InputView.bonusNumber());

    // 결과
    System.out.println("당첨 통계");
    System.out.println("---------------");

    Outcome outcome = new Outcome(money, lottos, winningNumber, bonus);

    int total = 0;
    Map<GradeEnum, Integer> result = outcome.statistic();

    // GradeEnum.values() 대신 none 만 안나오도록 설정해서 다시
    for(GradeEnum gradeEnum : GradeEnum.sorted()) {
      int size = result.getOrDefault(gradeEnum, 0);
      ResultView.result(gradeEnum, size);
      total += size * gradeEnum.prize();
    }
    
    ResultView.rate(outcome.profit(total));
    
    InputView.close();
  } 
}
