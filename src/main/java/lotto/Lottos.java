package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(Lotto... lottos){
        this(Arrays.asList(lottos));
    }

    public Lottos(List<Lotto> lottos){
        this.lottos = lottos;
    }

    public List<Lotto> findMatched(WinningNumber winningNumber, int matchedCount) {
        return findPrize(lottos, winningNumber, matchedCount);
    }

    private List<Lotto> findPrize(List<Lotto> lottos, WinningNumber winningNumber, int matchedCount) {
        return lottos.stream()
                .filter(it -> winningNumber.getMatchedNumberCount(it) == matchedCount )
                .collect(Collectors.toList());
    }
}
