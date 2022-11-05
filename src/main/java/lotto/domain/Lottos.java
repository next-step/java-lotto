package lotto.domain;

import static java.util.stream.Collectors.*;

import java.util.List;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Accordance> getAccordances(WinningNumbers winningNumbers, LottoNumber bonusNumber) {
        return lottos.stream()
            .map(lotto -> new Accordance(
                lotto.countSameNumbers(winningNumbers),
                lotto.containsBonusNumber(bonusNumber)
            ))
            .collect(toList());
    }

    public int getCount() {
        return lottos.size();
    }

    public List<Lotto> getLottos() {
        return List.copyOf(lottos);
    }
}
