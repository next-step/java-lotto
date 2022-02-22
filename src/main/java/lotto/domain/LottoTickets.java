package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoTickets {

    private final RandomLottoCount randomCounts;
    private final ManualCount manualCount;
    private final List<Lotto> lottoTickets = new ArrayList<>();

    public LottoTickets(final Price price, final ManualCount manualCount) {
        final LottoCounts lottoCounts = price.lottoCountsCalculator();
        this.randomCounts = new RandomLottoCount(lottoCounts, manualCount);
        this.manualCount = manualCount;
        if (randomCounts.possiblePurchaseRandomLotto()) {
            this.lottoTickets.addAll(makeRandomLottoTickets(randomCounts));
        }
    }

    public LottoTickets(final Price price, final ManualCount manualCount,
        final List<List<LottoNumber>> manualLine) {
        this(price, manualCount);
        this.lottoTickets.addAll(makeManualLottoTickets(manualLine));
    }

    private List<Lotto> makeRandomLottoTickets(final RandomLottoCount randomLottoCount) {
        final List<Lotto> randomLottos = new ArrayList<>();
        for (int i = 0; i < randomLottoCount.getCount(); i++) {
            randomLottos.add(new Lotto(new RandomLottoGenerator().getLottoGeneratorNumbers()));
        }
        return randomLottos;
    }

    private List<Lotto> makeManualLottoTickets(
        List<List<LottoNumber>> manualLine) {
        final List<Lotto> lottoTickets = new ArrayList<>();

        for (List<LottoNumber> line : manualLine) {
            lottoTickets.add(
                new Lotto(new ManualLottoGenerator(line).getLottoGeneratorNumbers()));
        }
        return lottoTickets;
    }

    public int getRandomLottoCounts() {
        return this.randomCounts.getCount();
    }

    public int getManualCount() {
        return this.manualCount.getManualCount();
    }

    public List<Lotto> getLottoTickets() {
        return lottoTickets;
    }

    public List<WinningResult> calculateWinningResult(final LottoMachine lottoMachine) {
        return lottoTickets.stream().map(winningResult -> new WinningResult(
            winningResult.compareLottoAndWinnerNumbers(lottoMachine),
            winningResult.compareLottoAndBonusNumbers(lottoMachine))).collect(
            Collectors.toList());
    }
}
