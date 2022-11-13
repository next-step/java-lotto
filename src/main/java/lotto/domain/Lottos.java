package lotto.domain;

import static java.util.stream.Collectors.*;

import java.util.List;
import java.util.stream.Stream;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos combine(Lottos lottos, Lottos others) {
        return Stream.concat(
                lottos.getLottos().stream(),
                others.getLottos().stream()
            )
            .collect(collectingAndThen(toList(), Lottos::new));
    }

    public List<Accordance> getAccordances(WinningNumbers winningNumbers, LottoNumber bonusNumber) {
        return lottos.stream()
            .map(lotto -> new Accordance(
                lotto.countSameNumbers(winningNumbers),
                lotto.containsBonusNumber(bonusNumber)
            ))
            .collect(toList());
    }

    public long countManualLottos() {
        return lottos.stream()
            .filter(Lotto::isManual)
            .count();
    }

    public long countAutoLottos() {
        return lottos.stream()
            .filter(lotto -> !lotto.isManual())
            .count();
    }

    public int getCount() {
        return lottos.size();
    }

    public List<Lotto> getLottos() {
        return List.copyOf(lottos);
    }
}
