package lotto.domain;

import lotto.strategy.LottoGeneratorAutoStrategy;
import lotto.strategy.LottoGeneratorManualStrategy;
import lotto.strategy.LottoGeneratorStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoTicket {
    private final List<Lotto> lottos;

    public LottoTicket(LottoCount lottoCount, List<String> manualLottos) {
        this.lottos = joined(lottoCount, manualLottos);
    }

    public LottoTicket(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    private List<Lotto> joined(LottoCount lottoCount, List<String> manualLottos) {
        List<Lotto> manuals = createManual(manualLottos);
        List<Lotto> autos = createAuto(lottoCount.number() - manuals.size());
        return Stream.concat(manuals.stream(), autos.stream()).collect(Collectors.toList());
    }

    private List<Lotto> createAuto(int autoCount) {
        LottoGeneratorStrategy lottoGeneratorStrategy = new LottoGeneratorAutoStrategy();
        List<Lotto> autos = new ArrayList<>();
        for (int i = 0; i < autoCount; i++) {
            Lotto lotto = new Lotto(lottoGeneratorStrategy);
            autos.add(lotto);
        }
        return autos;
    }

    private List<Lotto> createManual(List<String> manualLottos) {
        List<Lotto> manuals = new ArrayList<>();
        for (String manualLotto : manualLottos) {
            Lotto lotto = new Lotto(new LottoGeneratorManualStrategy(manualLotto));
            manuals.add(lotto);
        }
        return manuals;
    }

    public LottoWinning result(WinningNumbers winningNumbers) {
        LottoWinning winning = new LottoWinning();
        for (Lotto lotto : lottos) {
            winning.addCountOfMatch(
                    LottoRank.win(winningNumbers.matches(lotto), winningNumbers.hasBonusNumber(lotto)));
        }
        return winning;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
