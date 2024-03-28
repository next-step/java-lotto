package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(int count, LottoNumberStrategy strategy) {
        this.lottos = IntStream.range(0, count)
                .mapToObj(it -> new Lotto(LottoNumbers.create(strategy)))
                .collect(Collectors.toList());
    }

    public Lottos(List<LottoNumberStrategy> strategies) {
        this.lottos = strategies.stream()
                .map(it -> new Lotto(LottoNumbers.create(it)))
                .collect(Collectors.toList());
    }

    public int count() {
        return lottos.size();
    }

    public List<Rank> getRanks(LottoNumbers winNums, BonusNumber bonusNumber) {
        return lottos.stream()
                .map(lotto -> lotto.match(winNums, bonusNumber))
                .collect(Collectors.toList());
    }


    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }
}
