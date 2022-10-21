package step3.domian;

import java.util.*;
import java.util.stream.Collectors;

public class LottoWallet {

    public final List<Lotto> lottos;

    public LottoWallet(List<Lotto> lottos) {
        this.lottos = lottos;
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
