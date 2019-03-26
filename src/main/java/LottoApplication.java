import domain.*;
import util.Calculator;
import util.Console;
import util.Generator;
import view.InputView;
import view.ResultView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoApplication {
    public static void main(String[] args) {
        int money = InputView.inputMoney();
        if (money == 0) {
            return;
        }

        List<Lotto> lottos = new ArrayList<>();
        int lottoCount = ResultView.purchaseLottoCount(money);
        while (lottoCount-- > 0) {
            try {
                Lotto lotto = new Lotto(new LottoNumbers(Generator.lottoNumbers()));
                lottos.add(lotto);
                ResultView.printLotto(lotto);
            } catch (Exception e) {
                return;
            }
        }

        LottoNumbers lottoNumbers;
        try {
            lottoNumbers = new LottoNumbers(InputView.inputWinningNumbers());
        } catch (Exception e) {
            return;
        }

        int bonusBall = InputView.inputBonusBall();
        if (bonusBall == 0) {
            return;
        }

        if (lottoNumbers.isContains(bonusBall)) {
            Console.print("당첨번호와 보너스볼 숫자가 같을 수 없습니다.");
            return;
        }

        WinningNumbers winningNumbers = new WinningNumbers(lottoNumbers, bonusBall);

        Map<LottoRank, Integer> produceResult = new HashMap<>();
        for (Lotto lotto : lottos) {
            LottoRank lottoMatchCount = new LottoMatch(winningNumbers).matchResult(lotto);
            produceResult.putIfAbsent(lottoMatchCount, Calculator.nullToZero(produceResult.get(lottoMatchCount)) + 1);
        }

        ResultView.statisticsWinner(produceResult);
        ResultView.printYield(Calculator.yieldCalculator(produceResult, money));
    }
}
