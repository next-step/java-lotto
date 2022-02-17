package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.model.Count;
import lotto.model.Lotto;
import lotto.model.LottoNumber;
import lotto.model.LottoRules;
import lotto.model.Price;
import lotto.model.Rank;
import lotto.model.Ranks;
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
        int manualCount = InputView.inputManualLottoCount();
        Count count = price.calculateCount(manualCount);
        User user = new User(
            saveAllLottos(InputView.inputManualLottoNumber(manualCount), lottoRules, count));
        OutputView.printLottos(count, user.getLottos());
        WinningNumber winningNumber = new WinningNumber(InputView.inputWinningNumbers(),
            InputView.inputBonusBall());
        Ranks ranks = new Ranks();
        Map<Rank, Integer> rankMap = ranks.updateRanks(
            user.findEachLottoMatchingNumber(winningNumber));
        Statistics statistics = new Statistics(count.getCount(), ranks.calculateTotalPrize());
        OutputView.printStatistics(rankMap, statistics.calculateBenefits());
    }

    private List<Lotto> saveAllLottos(List<List<Integer>> manualLottoNumberInput,
        LottoRules lottoRules, Count count) {
        List<Lotto> lottos = new ArrayList<>();
        lottos.addAll(createManualLottos(manualLottoNumberInput));
        lottos.addAll(creatAutoLottos(lottoRules, count));
        return lottos;
    }

    private List<Lotto> creatAutoLottos(LottoRules lottoRules, Count count) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count.getAutoLottoCount(); i++) {
            lottos.add(new Lotto(lottoRules.makeLottoNumbers()));
        }
        return lottos;
    }

    private List<Lotto> createManualLottos(List<List<Integer>> manualLottoNumberInput) {
        List<LottoNumber> lottoNumbers;
        List<Lotto> manualLottos = new ArrayList<>();
        for (List<Integer> list : manualLottoNumberInput) {
            lottoNumbers = list.stream().map(LottoNumber::new).collect(
                Collectors.toList());
            manualLottos.add(new Lotto(lottoNumbers));
        }
        return manualLottos;
    }
}
