package step2.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static step2.domain.Lotto.ofLotto;

public class Lottos {
    static List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos ofLottoGames(int games) {
        return new Lottos(IntStream.range(0, games).mapToObj(i -> ofLotto()).collect(Collectors.toList()));
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public List<Scores> getWinningInfos(WinnersNo winnersNo) {
        return lottos.stream()
                     .filter(Objects::nonNull)
                     .map(l -> l.addWinningInfos(winnersNo))
                     .collect(Collectors.toList());
    }
}
