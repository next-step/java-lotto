package step3.domian;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LottoWallet {

    public final List<Lotto> lottos;

    public LottoWallet(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public LottoResult compareWithLastLotto(LastWinner lastWinner) {
        return new LottoResult(this.lottos.stream().map(lotto -> {
                    int count = lotto.countSameNumber(lastWinner);
                    return Prize.getPrize(count, lotto, lastWinner.bonus);
                }).filter(it -> it != null)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())));
    }
}
