package step2.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static step2.domain.Lotto.ofRandomLotto;

public class Lottos {
    static List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos ofAutoLottoGames(int games) {
        return new Lottos(getAutoLottos(games));
    }

    private static List<Lotto> getAutoLottos(int games) {
        return IntStream.range(0, games).mapToObj(i -> ofRandomLotto()).collect(Collectors.toList());
    }

    public static Lottos ofManualLottoGames(List<String> strings) {
        return new Lottos(getManualLottos(strings));
    }

    private static List<Lotto> getManualLottos(List<String> strings) {
        return strings.stream()
                      .map(inputManualLottoNumber -> Lotto.ofLotto(Numbers.convertStringToNo(inputManualLottoNumber)))
                      .collect(Collectors.toList());
    }

    public static Lottos ofAutoAndManualLottoGames(int games, List<String> strings) {
        return new Lottos(Stream.concat(getManualLottos(strings).stream(), getAutoLottos(games).stream())
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
