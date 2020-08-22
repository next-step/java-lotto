package step2.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static step2.domain.Lotto.ofLotto;

public class Lottos {
    List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos ofLottoGames(int games) {
        return new Lottos(IntStream.range(0, games).mapToObj(i -> ofLotto()).collect(Collectors.toList()));
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
