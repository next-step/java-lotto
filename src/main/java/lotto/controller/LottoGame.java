package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import lotto.model.AutoLottoGenerator;
import lotto.model.Count;
import lotto.model.Lotto;
import lotto.dto.LottoDto;
import lotto.model.LottoNumber;
import lotto.model.ManualLottoGenerator;
import lotto.model.MatchInfo;
import lotto.model.Price;
import lotto.model.Rank;
import lotto.model.Ranks;
import lotto.model.Statistics;
import lotto.model.User;
import lotto.model.WinningNumber;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGame {

    private static final LottoGame lottoGame = new LottoGame();

    private LottoGame() {
    }

    public static LottoGame getInstance() {
        return lottoGame;
    }

    public void play() {
        Price price = new Price(InputView.inputPrice());
        Count count = new Count(price.calculateTotalCount(), InputView.inputManualLottoCount());
        List<LottoDto> manualLottoNumbers = InputView.inputManualLottoNumber(
            count.getManualLottoCount());
        User user = saveAllLottos(manualLottoNumbers, count);
        printLottos(count, user);
        WinningNumber winningNumber = new WinningNumber(InputView.inputWinningNumbers(),
            InputView.inputBonusBall());
        List<MatchInfo> matchInfos = user.findEachLottoMatchingNumber(winningNumber);
        Map<Rank, Integer> totalRanks = updateRankByMatchInfo(matchInfos);
        printStatistics(count, totalRanks);
    }

    private void printLottos(Count count, User user) {
        OutputView.printLottos(count, user.getLottos());
    }

    private void printStatistics(Count count, Map<Rank, Integer> totalRanks) {
        Statistics statistics = new Statistics(count, totalRanks);
        OutputView.printStatistics(totalRanks, statistics.calculateBenefits());
    }

    private Map<Rank, Integer> updateRankByMatchInfo(List<MatchInfo> matchInfos) {
        Ranks ranks = new Ranks();
        return ranks.updateRanks(matchInfos);
    }

    private User saveAllLottos(List<LottoDto> manualLottoNumbers, Count count) {
        List<Lotto> lottos = new ArrayList<>();
        lottos.addAll(createManualLottos(manualLottoNumbers));
        lottos.addAll(creatAutoLottos(count));
        return new User(lottos);
    }

    private List<Lotto> creatAutoLottos(Count count) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count.getAutoLottoCount(); i++) {
            List<LottoNumber> autoLotto = new AutoLottoGenerator().generateLotto();
            lottos.add(new Lotto(autoLotto));
        }
        return lottos;
    }

    private List<Lotto> createManualLottos(List<LottoDto> manualLottoNumbers) {
        List<Lotto> manualLottos = new ArrayList<>();
        for (LottoDto lottoDto : manualLottoNumbers) {
            List<LottoNumber> manualLotto = new ManualLottoGenerator(
                lottoDto.getManualLottoNumbers()).generateLotto();
            manualLottos.add(new Lotto(manualLotto));
        }
        return manualLottos;
    }
}
