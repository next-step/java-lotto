package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import lotto.model.Count;
import lotto.model.Lotto;
import lotto.model.LottoRules;
import lotto.model.Price;
import lotto.model.Rank;
import lotto.model.Statistics;
import lotto.model.User;
import lotto.model.WinningNumber;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoAuto {

    private static final LottoAuto lottoAuto = new LottoAuto();

    private LottoAuto() {
    }

    public static LottoAuto getInstance() {
        return lottoAuto;
    }

    public void play() {
        LottoRules lottoRules = new LottoRules();
        Price price = new Price(InputView.inputPrice());
        Count count = price.calculateCount();
        OutputView.printLottoCount(count.getCount());
        User user = new User(createLottos(lottoRules, count));
        OutputView.printLottos(user.getLottos());
        WinningNumber winningNumber = new WinningNumber(InputView.inputWinningNumbers(),
            InputView.inputBonusBall());
        Statistics statistics = new Statistics(count.getCount());
        Map<Rank, Integer> ranks = statistics.updateRanks(
            user.findEachLottoMatchingNumber(winningNumber));
        OutputView.printStatistics(ranks, statistics.calculateBenefits());
    }

    private List<Lotto> createLottos(LottoRules lottoRules, Count count) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count.getCount(); i++) {
            lottos.add(new Lotto(lottoRules.makeLottoNumbers()));
        }
        return lottos;
    }
}
