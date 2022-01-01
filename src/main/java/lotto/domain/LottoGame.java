package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lotto.utils.NumberStrategy;
import lotto.utils.RandomNumberStrategy;

public class LottoGame {

    private List<Lotto> lottos;

    private static final NumberStrategy numberStrategy = new RandomNumberStrategy();

    public LottoGame(int number) {
        setLottos(number);
    }

    public LottoGame(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    private void setLottos(int number) {
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            lottoList.add(new Lotto(numberStrategy));
        }
        this.lottos = lottoList;
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(this.lottos);
    }

    public LottoResult draw(Set<Integer> winningNumber) {
        List<Integer> matchNumbers = matchCounts(winningNumber);
        return new LottoResult(matchNumbers);
    }

    private List<Integer> matchCounts(Set<Integer> winningNumber) {
        return this.lottos.stream()
            .map(lotto -> lotto.matchCount(winningNumber))
            .collect(Collectors.toList());
    }
}
