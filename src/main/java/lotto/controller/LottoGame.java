package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import lotto.model.AutoLottoRules;
import lotto.model.Count;
import lotto.model.Lotto;
import lotto.model.ManualLotto;
import lotto.model.Price;
import lotto.model.Rank;
import lotto.model.Ranks;
import lotto.model.Statistics;
import lotto.model.User;
import lotto.model.WinningNumber;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGame {

    private static final LottoGame lottoAuto = new LottoGame();

    private LottoGame() {
    }

    public static LottoGame getInstance() {
        return lottoAuto;
    }

    public void play() {
        Price price = new Price(InputView.inputPrice());
        Count count = new Count(price.calculateTotalCount(), InputView.inputManualLottoCount());
        User user = saveAllLottos(InputView.inputManualLottoNumber(count.getManualLottoCount()),
            count);
        OutputView.printLottos(count, user.getLottos());
        WinningNumber winningNumber = new WinningNumber(InputView.inputWinningNumbers(),
            InputView.inputBonusBall());
        Ranks ranks = new Ranks();
        Map<Rank, Integer> rankMap = ranks.updateRanks(
            user.findEachLottoMatchingNumber(winningNumber));
        Statistics statistics = new Statistics(count.getCount(), ranks.calculateTotalPrize());
        OutputView.printStatistics(rankMap, statistics.calculateBenefits());
    }

    private User saveAllLottos(List<ManualLotto> manualLottoNumberInput, Count count) {
        List<Lotto> lottos = new ArrayList<>();
        lottos.addAll(createManualLottos(manualLottoNumberInput));
        lottos.addAll(creatAutoLottos(count));
        return new User(lottos);
    }

    private List<Lotto> creatAutoLottos(Count count) {
        AutoLottoRules autoLottoRules = new AutoLottoRules();
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count.getAutoLottoCount(); i++) {
            lottos.add(new Lotto(autoLottoRules.makeLottoNumbers()));
        }
        return lottos;
    }

    private List<Lotto> createManualLottos(List<ManualLotto> manualLottoNumberInput) {
        List<Lotto> manualLottos = new ArrayList<>();
        for (ManualLotto manualLotto : manualLottoNumberInput) {
            manualLottos = manualLotto.addManualLotto(manualLottos);
        }
        return manualLottos;
    }
}
