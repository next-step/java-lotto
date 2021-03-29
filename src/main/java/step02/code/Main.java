package step02.code;

import java.util.Map;

import step02.code.common.InputView;
import step02.code.common.ResultView;
import step02.code.domain.GradeEnum;
import step02.code.domain.Lotto;
import step02.code.domain.Lottos;
import step02.code.domain.Outcome;

public class Main {
  public static void main(String[] args) {
    int money = InputView.buy();

    Lottos lottos = Lottos.buy(money);
    ResultView.myLotto(lottos.lottos());

    Lotto winningNumber = Lotto.makeLottoByString(InputView.winningNumber());

    // 결과
    System.out.println("당첨 통계");
    System.out.println("---------------");

    Outcome outcome = new Outcome(money, lottos, winningNumber);

    int total = 0;
    Map<Integer, Integer> result = outcome.statistic();
    for(int i = 3; i <= 6; i++) {
      GradeEnum grade = GradeEnum.fromGrade(i);
      int matched = result.getOrDefault(i, 0);
      
      total += grade.prize() * matched;

      ResultView.result(i, grade.prize(), matched);
    }

    ResultView.rate(outcome.profit(total));
    
    InputView.close();
  } 
}
