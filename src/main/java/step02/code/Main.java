package step02.code;

import java.util.Map;

import step02.code.common.InputView;
import step02.code.common.ResultView;
import step02.code.domain.GradeEnum;
import step02.code.domain.Lotto;
import step02.code.domain.Lottos;
import step02.code.domain.WinningNumber;

public class Main {
  public static void main(String[] args) {
    int money = InputView.buy();

    Lottos lottos = new Lottos(money);
    ResultView.myLotto(lottos.lottos());

    WinningNumber winningNumber = WinningNumber.makeWinningNumberByString(InputView.winningNumber());
    // winningNumber validation check 용
    new Lotto(winningNumber.number());

    // 결과
    System.out.println("당첨 통계");
    System.out.println("---------------");

    int total = 0;
    Map<Integer, Integer> result = lottos.result(winningNumber.number());
    for(int i = 3; i <= 6; i++) {
      GradeEnum grade = GradeEnum.fromGrade(i);
      int matched = result.getOrDefault(i, 0);
      
      total += grade.prize() * matched;

      ResultView.result(i, grade.prize(), matched);
    }

    float rate = (float) total / money;
    ResultView.rate(rate);
    
    InputView.close();
  } 
}
