package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoTickets {


    private static final int NOT_PURCHASE_RANDOM_LOTTO = 0;

    private final int randomCounts;
    private final int manualCount;
    private final List<Lotto> lottoTickets = new ArrayList<>();

    public LottoTickets(final Price price, final ManualCount manualCount) {
        final LottoCounts lottoCounts = price.lottoCountsCalculator();
        this.randomCounts = lottoCounts.getLottoCounts() - manualCount.getManualCount();
        this.manualCount = manualCount.getManualCount();
        if (randomCounts > NOT_PURCHASE_RANDOM_LOTTO) {
            this.lottoTickets.addAll(makeRandomLottoTickets(randomCounts));
        }
    }

    public LottoTickets(final Price price, final ManualCount manualCount,
        final List<List<LottoNumber>> manualLine) {
        this(price, manualCount);
        this.lottoTickets.addAll(makeManualLottoTickets(manualLine));
    }

    private List<Lotto> makeRandomLottoTickets(final int lottoCount) {
        final List<Lotto> randomLottos = new ArrayList<>();
        if (lottoCount > 0) {
            for (int i = 0; i < lottoCount; i++) {
                randomLottos.add(new Lotto(new RandomLottoGenerator().getLottoGeneratorNumbers()));
            }
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
        return this.randomCounts;
    }

    public int getManualCount() {
        return this.manualCount;
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
