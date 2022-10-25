package step4.domian;

import java.util.Collection;
import java.util.EnumMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoWallet {

    public final List<Lotto> lottos;

    public LottoWallet(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public LottoWallet(List<Lotto> manual, List<Lotto> autos) {
        this(Stream.of(manual, autos)
                .flatMap(Collection::stream)
                .collect(Collectors.toList()));
    }

    public LottoResult compareWithLastLotto(LastWinner lastWinner) {
        return new LottoResult(this.lottos.stream().map(lotto -> {
                    int count = lastWinner.countSameNumber(lotto);
                    return Prize.getPrize(count, checkBonus(count, lastWinner, lotto));
                }).filter(it -> it != null)
                .collect(Collectors.toMap(
                        prize -> prize,
                        prize -> 1L,
                        Long::sum,
                        () -> new EnumMap<>(Prize.class)))
        );
    }

    private boolean checkBonus(int count, LastWinner lastWinner, Lotto lotto) {
        if (count == 5) {
            return lastWinner.isContainBonus(lotto);
        }
        return false;
    }
}
