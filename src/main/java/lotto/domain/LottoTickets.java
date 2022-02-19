package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoTickets {

    private static final int LOTTO_PRICE = 1000;

    private final int randomCounts;
    private final int manualCount;
    private final List<Lotto> lottoTickets = new ArrayList<>();

    public LottoTickets(final int price, final int manualCount,
        final List<List<Integer>> manualLine) {
        final int lottoCounts = price / LOTTO_PRICE;
        this.randomCounts = lottoCounts - manualCount;
        this.manualCount = manualCount;
        this.lottoTickets.addAll(makeManualLottoTickets(manualLine));
        if (randomCounts > 0) {
            this.lottoTickets.addAll(makeRandomLottoTickets(randomCounts));
        }
    }

    public LottoTickets(final int price, final int manualCount) {
        final int lottoCounts = price / LOTTO_PRICE;
        this.randomCounts = lottoCounts - manualCount;
        this.manualCount = manualCount;
        this.lottoTickets.addAll(makeRandomLottoTickets(this.randomCounts));
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
        List<List<Integer>> manualLine) {
        final List<Lotto> lottoTickets = new ArrayList<>();

        for (List<Integer> line : manualLine) {
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
