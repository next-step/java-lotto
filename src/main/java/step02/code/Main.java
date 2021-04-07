package step02.code;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import step02.code.common.InputView;
import step02.code.common.ResultView;
import step02.code.domain.GradeEnum;
import step02.code.domain.Lotto;
import step02.code.domain.Lottos;
import step02.code.domain.Number;
import step02.code.domain.Outcome;
import step02.code.domain.ResultCalculator;

public class Main {
  public static void main(String[] args) {
    int money = InputView.buy();

    int passiveLottoSize = InputView.passiveLottoSize();
    List<Lotto> passiveLottos = new ArrayList<>();
    System.out.println("수동으로 구매할 번호를 입력해 주세요.");
    for(int i = 0; i < passiveLottoSize; i++) {
      passiveLottos.add(Lotto.makeLottoByString(InputView.passiveLotto()));
    }

    Lottos lottos = Lottos.buy(money, passiveLottos);
    ResultView.myLotto(lottos.lottos(), passiveLottoSize);

    Lotto winningNumber = Lotto.makeLottoByString(InputView.winningNumber());

    Number bonus = Number.numberByString(InputView.bonusNumber());

    // 결과
    System.out.println("당첨 통계");
    System.out.println("---------------");

    Outcome outcome = new Outcome(lottos);
    Map<GradeEnum, Integer> result = outcome.statistic(winningNumber, bonus);
    
    ResultCalculator resultCalculator = new ResultCalculator(money);
    
    ResultView.result(result);

    // 불변 객체로 구현해 보고 싶어서 이런식으로 구현해봤습니다.
    resultCalculator = resultCalculator.calcTotal(result);
    ResultView.rate(resultCalculator.profit());
    
    InputView.close();
  } 
}
