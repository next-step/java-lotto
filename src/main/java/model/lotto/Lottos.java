package model.lotto;

import java.util.EnumMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public Lottos(List<Lotto> manualLottos, List<Lotto> autoLottos) {
        this.lottos = Stream.of(manualLottos, autoLottos)
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }

    public EnumMap<Rank, Integer> countWinningNumbers(WinningLotto winningLotto) {
        return lottos.stream()
                .map(lotto -> lotto.countWinningNumbers(winningLotto))
                .collect(Collectors.toMap(
                        rank -> rank,
                        rank -> 1,
                        Integer::sum,
                        () -> new EnumMap<>(Rank.class)
                ));
    }

    public void getAllLottoNumbers(){
        lottos.forEach(lotto -> System.out.println(lotto.toString()));
    }
}
