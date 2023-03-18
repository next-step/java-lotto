package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoBall;
import lotto.domain.LottoGrades;
import lotto.domain.LottoPromoter;

import java.util.List;
import java.util.Map;

public class LottoGame {

    public static void main(String[] args) {
        LottoView view = new LottoView();
        int money = view.insertMoney();

        LottoPromoter promoter = new LottoPromoter();
        List<Lotto> lottos = promoter.buyLottos(money);
        view.printLottos(lottos);

        List<Integer> numbers = view.insertWinningLottoNumbers();
        Lotto winningLotto = promoter.createLotto(numbers);

        int bonusNumber = view.insertBonusBallNumbers();
        LottoBall bonusBall = new LottoBall(bonusNumber);

        view.printStatistics();
        Map<LottoGrades.LottoGrade, Integer> lottoResults = promoter.checkLottoGrades(lottos, winningLotto, bonusBall);
        lottoResults.keySet().stream()
                .forEach(lottoGrade -> view.printLottoGrade(lottoGrade, lottoResults.get(lottoGrade)));

        double earningRate = promoter.getPrizeMoney(lottoResults) / money;
        view.printTotalEarningRate(earningRate);

    }

}
