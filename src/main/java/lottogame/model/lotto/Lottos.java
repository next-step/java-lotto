package lottogame.model.lotto;

import java.util.ArrayList;
import java.util.List;
import lottogame.model.winner.Rank;
import lottogame.model.winner.WinnerResult;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public WinnerResult compareAndElectWinResult(final WinningLottoNums winningLottoNums) {
        WinnerResult winnerResult = new WinnerResult();
        for (Lotto lotto : lottos) {
            Rank RANK = winningLottoNums.checkIfWin(lotto);
            winnerResult.addWinResult(RANK);
        }

        return winnerResult;
    }

    public int size() {
        return this.lottos.size();
    }

    public List<String> convertRawString() {
        return this.lottos.stream()
                .map(Lotto::toString)
                .toList();
    }

    public Lottos merge(Lottos additionalLottos) {
        List<Lotto> mergedLottos = new ArrayList<>(this.lottos);
        mergedLottos.addAll(additionalLottos.lottos);

        return new Lottos(mergedLottos);
    }
}
