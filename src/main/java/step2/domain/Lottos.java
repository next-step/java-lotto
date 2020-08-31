package step2.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lottos {
    static List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos ofAutoLottoGames(List<Lotto> autoLottos) {
        return new Lottos(autoLottos);
    }

    public static Lottos ofAutoAndManualLottoGames(List<Lotto> autoLottos, List<Lotto> manualLottos) {
        return new Lottos(Stream.concat(manualLottos.stream(), autoLottos.stream())
                                .collect(Collectors.toList()));
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public List<ScoreType> getWinningInfos(WinnersNo winnersNo) {
        return lottos.stream()
                     .filter(Objects::nonNull)
                     .map(l -> l.addWinningInfos(winnersNo))
                     .collect(Collectors.toList());
    }
}
