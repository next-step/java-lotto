package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoBall;
import lotto.domain.LottoGrades;
import lotto.domain.LottoPromoter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class ManualLottoGame {

    private static final LottoPromoter promoter = new LottoPromoter();

    private static final LottoView view = new LottoView();

    public static void main(String[] args) {
        int money = view.insertMoney();

        int manualCount = view.insertManualLottoCount();
        int lottoCount = promoter.getLottoCount(money);
        view.printMoneyCheckMessage(lottoCount, manualCount);

        List<Lotto> lottos = getManualLottos(manualCount);

        int autoCount = lottoCount - manualCount;
        view.printTotalLottoCount(manualCount, autoCount);

        lottos.addAll(promoter.buyLottos(autoCount));
        view.printLottos(lottos);

        List<Integer> numbers = view.insertWinningLottoNumbers();
        Lotto winningLotto = promoter.createLotto(numbers);

        int bonusNumber = view.insertBonusBallNumbers();
        LottoBall bonusBall = new LottoBall(bonusNumber);

        view.printStatistics();
        Map<LottoGrades.LottoGrade, Integer> lottoResults = promoter.checkLottoGrades(lottos, winningLotto, bonusBall);
        lottoResults.keySet().stream()
                .sorted(Comparator.reverseOrder())
                .forEach(lottoGrade -> view.printLottoGrade(lottoGrade, lottoResults.get(lottoGrade)));

        double earningRate = promoter.getPrizeMoney(lottoResults) / money;
        view.printTotalEarningRate(earningRate);

    }

    private static List<Lotto> getManualLottos(int manualCount) {
        view.printManualLottoMessage();

        List<Lotto> lottos = new ArrayList<>();
        for(int i = 0; i <manualCount; i++) {
            List<Integer> numbers = view.insertLottoNumbers();
            lottos.add(promoter.createLotto(numbers));
        }
        return lottos;
    }
}
